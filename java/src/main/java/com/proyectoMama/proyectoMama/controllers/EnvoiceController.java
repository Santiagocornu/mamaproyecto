package com.proyectoMama.proyectoMama.controllers;

import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.Envoice;
import com.proyectoMama.proyectoMama.services.EnvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/envoices")

public class EnvoiceController {

    @Autowired
    private EnvoiceService envoiceService;

    @GetMapping
    public List<Envoice> getAllEnvoices() {
        return envoiceService.getAllEnvoices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envoice> getEnvoiceById(@PathVariable Long id) {
        Envoice envoice = envoiceService.getEnvoiceById(id);
        if (envoice != null) {
            return ResponseEntity.ok(envoice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Envoice createEnvoice(@RequestBody Envoice envoice) {
        return envoiceService.createEnvoice(envoice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Envoice> updateEnvoice(@PathVariable Long id, @RequestBody Envoice envoiceDetails) {
        Envoice updatedEnvoice = envoiceService.updateEnvoice(id, envoiceDetails);
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
}



