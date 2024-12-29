package com.proyectoMama.proyectoMama.controllers;

import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.Envoice;

import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.EnvoiceDTO;
import com.proyectoMama.proyectoMama.services.ClientService;
import com.proyectoMama.proyectoMama.services.EmployerService;
import com.proyectoMama.proyectoMama.services.EnvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/envoices")
@CrossOrigin(origins = "http://localhost:3000")
public class EnvoiceController {

    @Autowired
    private EnvoiceService envoiceService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private EmployerService employerService;

    @GetMapping
    public List<EnvoiceDTO> getAllEnvoices() {
        List<Envoice> envoices = envoiceService.getAllEnvoices();
        return envoices.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvoiceDTO> getEnvoiceById(@PathVariable Long id) {
        Optional<Envoice> envoice = envoiceService.getEnvoiceById(id);
        return envoice.map(value -> ResponseEntity.ok(convertToDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public EnvoiceDTO createEnvoice(@RequestBody Envoice envoice) {
        Envoice createdEnvoice = envoiceService.createEnvoice(envoice);
        return convertToDTO(createdEnvoice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvoiceDTO> updateEnvoice(@PathVariable Long id, @RequestBody Envoice envoiceDetails) {
        Optional<Envoice> updatedEnvoice = envoiceService.updateEnvoice(id, envoiceDetails);
        return updatedEnvoice.map(value -> ResponseEntity.ok(convertToDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvoice(@PathVariable Long id) {
        if (envoiceService.deleteEnvoice(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/associateClient")
    public ResponseEntity<EnvoiceDTO> associateClient(@PathVariable Long id, @RequestParam Long clientId) {
        Envoice updatedEnvoice = envoiceService.associateClient(id, clientId);
        if (updatedEnvoice != null) {
            return ResponseEntity.ok(convertToDTO(updatedEnvoice));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/associateEmployer")
    public ResponseEntity<EnvoiceDTO> associateEmployer(@PathVariable Long id, @RequestParam Long employerId) {
        Envoice updatedEnvoice = envoiceService.associateEmployer(id, employerId);
        if (updatedEnvoice != null) {
            return ResponseEntity.ok(convertToDTO(updatedEnvoice));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private EnvoiceDTO convertToDTO(Envoice envoice) {
        EnvoiceDTO dto = new EnvoiceDTO();
        dto.setId_envoice(envoice.getId_envoice());
        dto.setNombre_envoice(envoice.getNombre_envoice());
        dto.setMedioPago_envoice(envoice.getMedioPago_envoice());
        dto.setTotal_envoice(envoice.getTotal_envoice());
        dto.setClient_id(envoice.getClient() != null ? envoice.getClient().getId_person() : null);
        return dto;
    }
}





