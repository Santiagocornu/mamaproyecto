package com.proyectoMama.proyectoMama.controllers;

import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.EnvoiceProduct;
import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.EnvoiceProductDTO;
import com.proyectoMama.proyectoMama.services.EnvoiceProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/envoiceProducts")
@CrossOrigin(origins = "http://localhost:3000")
public class EnvoiceProductController {

    @Autowired
    private EnvoiceProductService envoiceProductService;

    @GetMapping
    public List<EnvoiceProductDTO> getAllEnvoiceProducts() {
        return envoiceProductService.getAllEnvoiceProducts().stream()
                .map(envoiceProductService::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvoiceProductDTO> getEnvoiceProductById(@PathVariable Long id) {
        EnvoiceProduct envoiceProduct = envoiceProductService.getEnvoiceProductById(id);
        if (envoiceProduct != null) {
            return ResponseEntity.ok(envoiceProductService.convertToDTO(envoiceProduct));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EnvoiceProductDTO> createEnvoiceProduct(@RequestBody EnvoiceProductDTO dto) {
        try {
            EnvoiceProduct envoiceProduct = envoiceProductService.convertToEntity(dto);
            EnvoiceProduct createdEnvoiceProduct = envoiceProductService.createEnvoiceProduct(envoiceProduct);
            return ResponseEntity.ok(envoiceProductService.convertToDTO(createdEnvoiceProduct));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvoiceProductDTO> updateEnvoiceProduct(@PathVariable Long id, @RequestBody EnvoiceProductDTO dto) {
        EnvoiceProduct envoiceProductDetails = envoiceProductService.convertToEntity(dto);
        EnvoiceProduct updatedEnvoiceProduct = envoiceProductService.updateEnvoiceProduct(id, envoiceProductDetails);
        if (updatedEnvoiceProduct != null) {
            return ResponseEntity.ok(envoiceProductService.convertToDTO(updatedEnvoiceProduct));
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

    @PutMapping("/{id}/associateEnvoice")
    public ResponseEntity<EnvoiceProductDTO> associateEnvoice(@PathVariable Long id, @RequestParam Long envoiceId) {
        EnvoiceProduct updatedEnvoiceProduct = envoiceProductService.associateEnvoice(id, envoiceId);
        if (updatedEnvoiceProduct != null) {
            return ResponseEntity.ok(envoiceProductService.convertToDTO(updatedEnvoiceProduct));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/associateProduct")
    public ResponseEntity<EnvoiceProductDTO> associateProduct(@PathVariable Long id, @RequestParam Long productId) {
        EnvoiceProduct updatedEnvoiceProduct = envoiceProductService.associateProduct(id, productId);
        if (updatedEnvoiceProduct != null) {
            return ResponseEntity.ok(envoiceProductService.convertToDTO(updatedEnvoiceProduct));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


