package com.proyectoMama.proyectoMama.controllers;

import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.Envoice;

import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.EnvoiceDTO;
import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.EnvoiceProductDTO;
import com.proyectoMama.proyectoMama.services.ClientService;
import com.proyectoMama.proyectoMama.services.EmployerService;
import com.proyectoMama.proyectoMama.services.EnvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/envoices")
@CrossOrigin(origins = "http://localhost:3000")
public class EnvoiceController {

    @Autowired
    private EnvoiceService envoiceService;

    @GetMapping
    public List<EnvoiceDTO> getAllEnvoices() {
        return envoiceService.getAllEnvoices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvoiceDTO> getEnvoiceById(@PathVariable Long id) {
        EnvoiceDTO envoiceDTO = envoiceService.getEnvoiceById(id);
        if (envoiceDTO != null) {
            return ResponseEntity.ok(envoiceDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public EnvoiceDTO createEnvoice(@RequestBody EnvoiceDTO envoiceDTO) {
        return envoiceService.createEnvoice(envoiceDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvoiceDTO> updateEnvoice(@PathVariable Long id, @RequestBody EnvoiceDTO envoiceDTO) {
        EnvoiceDTO updatedEnvoice = envoiceService.updateEnvoice(id, envoiceDTO);
        if (updatedEnvoice != null) {
            return ResponseEntity.ok(updatedEnvoice);
        } else {
            return ResponseEntity.notFound().build();
        }
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
        EnvoiceDTO updatedEnvoice = envoiceService.associateClient(id, clientId);
        if (updatedEnvoice != null) {
            return ResponseEntity.ok(updatedEnvoice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}/associateEmployer")
    public ResponseEntity<EnvoiceDTO> associateEmployer(@PathVariable Long id, @RequestParam Long employerId) {
        EnvoiceDTO updatedEnvoice = envoiceService.associateEmployer(id, employerId);
        if (updatedEnvoice != null) {
            return ResponseEntity.ok(updatedEnvoice);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<EnvoiceProductDTO>> getProductsByEnvoiceId(@PathVariable Long id) {
        List<EnvoiceProductDTO> products = envoiceService.getProductsByEnvoiceId(id);
        if (products != null && !products.isEmpty()) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}







