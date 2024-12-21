package com.proyectoMama.proyectoMama.controllers;

import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.Envoice;
import com.proyectoMama.proyectoMama.services.EnvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/envoices")
@CrossOrigin(origins = "http://localhost:3000")
public class EnvoiceController {
    @Autowired
    private EnvoiceService envoiceService;

    @GetMapping
    public List<Envoice> getAllEnvoices() {
        return envoiceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envoice> getEnvoiceById(@PathVariable Long id) {
        Optional<Envoice> envoice = envoiceService.findById(id);
        return envoice.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Envoice createEnvoice(@RequestBody Envoice envoice) {
        return envoiceService.save(envoice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Envoice> updateEnvoice(@PathVariable Long id, @RequestBody Envoice envoiceDetails) {
        Optional<Envoice> envoice = envoiceService.findById(id);
        if (envoice.isPresent()) {
            Envoice updatedEnvoice = envoice.get();
            updatedEnvoice.setNombre_envoice(envoiceDetails.getNombre_envoice());
            updatedEnvoice.setMedioPago_envoice(envoiceDetails.getMedioPago_envoice());
            updatedEnvoice.setTotal_envoice(envoiceDetails.getTotal_envoice());
            updatedEnvoice.setClient(envoiceDetails.getClient());
            updatedEnvoice.setEmployer(envoiceDetails.getEmployer());
            return ResponseEntity.ok(envoiceService.save(updatedEnvoice));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvoice(@PathVariable Long id) {
        if (envoiceService.findById(id).isPresent()) {
            envoiceService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
