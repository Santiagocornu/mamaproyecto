package com.proyectoMama.proyectoMama.controllers;

import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.EnvoiceProduct;
import com.proyectoMama.proyectoMama.services.EnvoiceProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/envoiceProducts")
@CrossOrigin(origins = "http://localhost:3000")
public class EnvoiceProductController {

    @Autowired
    private EnvoiceProductService envoiceProductService;

    @GetMapping
    public List<EnvoiceProduct> getAllEnvoiceProducts() {
        return envoiceProductService.getAllEnvoiceProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvoiceProduct> getEnvoiceProductById(@PathVariable Long id) {
        EnvoiceProduct envoiceProduct = envoiceProductService.getEnvoiceProductById(id);
        if (envoiceProduct != null) {
            return ResponseEntity.ok(envoiceProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public EnvoiceProduct createEnvoiceProduct(@RequestBody EnvoiceProduct envoiceProduct) {
        return envoiceProductService.createEnvoiceProduct(envoiceProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvoiceProduct> updateEnvoiceProduct(@PathVariable Long id, @RequestBody EnvoiceProduct envoiceProductDetails) {
        EnvoiceProduct updatedEnvoiceProduct = envoiceProductService.updateEnvoiceProduct(id, envoiceProductDetails);
        if (updatedEnvoiceProduct != null) {
            return ResponseEntity.ok(updatedEnvoiceProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvoiceProduct(@PathVariable Long id) {
        if (envoiceProductService.deleteEnvoiceProduct(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



