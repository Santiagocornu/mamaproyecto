package com.proyectoMama.proyectoMama.controllers;

import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.EnvoiceProduct;
import com.proyectoMama.proyectoMama.services.EnvoiceProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/envoice-products")
@CrossOrigin(origins = "http://localhost:3000")
public class EnvoiceProductController {
    @Autowired
    private EnvoiceProductService envoiceProductService;

    @GetMapping
    public List<EnvoiceProduct> getAllEnvoiceProducts() {
        return envoiceProductService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvoiceProduct> getEnvoiceProductById(@PathVariable Long id) {
        Optional<EnvoiceProduct> envoiceProduct = envoiceProductService.findById(id);
        return envoiceProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public EnvoiceProduct createEnvoiceProduct(@RequestBody EnvoiceProduct envoiceProduct) {
        return envoiceProductService.save(envoiceProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvoiceProduct> updateEnvoiceProduct(@PathVariable Long id, @RequestBody EnvoiceProduct envoiceProductDetails) {
        Optional<EnvoiceProduct> envoiceProduct = envoiceProductService.findById(id);
        if (envoiceProduct.isPresent()) {
            EnvoiceProduct updatedEnvoiceProduct = envoiceProduct.get();
            updatedEnvoiceProduct.setEnvoice(envoiceProductDetails.getEnvoice());
            updatedEnvoiceProduct.setProduct(envoiceProductDetails.getProduct());
            updatedEnvoiceProduct.setCantidad(envoiceProductDetails.getCantidad());
            return ResponseEntity.ok(envoiceProductService.save(updatedEnvoiceProduct));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvoiceProduct(@PathVariable Long id) {
        if (envoiceProductService.findById(id).isPresent()) {
            envoiceProductService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

