package com.proyectoMama.proyectoMama.services;

import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.*;
import com.proyectoMama.proyectoMama.repositories.EnvoiceProductRepository;
import com.proyectoMama.proyectoMama.repositories.EnvoiceRepository;
import com.proyectoMama.proyectoMama.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class EnvoiceProductService {

    @Autowired
    private EnvoiceProductRepository envoiceProductRepository;

    @Autowired
    private EnvoiceRepository envoiceRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<EnvoiceProduct> getAllEnvoiceProducts() {
        return envoiceProductRepository.findAll();
    }

    public EnvoiceProduct getEnvoiceProductById(Long id) {
        return envoiceProductRepository.findById(id).orElse(null);
    }

    public EnvoiceProduct createEnvoiceProduct(EnvoiceProduct envoiceProduct) {
        Assert.notNull(envoiceProduct.getEnvoice(), "Envoice must not be null");
        Assert.notNull(envoiceProduct.getProduct(), "Product must not be null");

        // Asignar Envoice y Product a partir de sus IDs
        Envoice envoice = envoiceRepository.findById(envoiceProduct.getEnvoice().getId_envoice())
                .orElseThrow(() -> new IllegalArgumentException("Invalid envoice ID"));
        Product product = productRepository.findById(envoiceProduct.getProduct().getId_product())
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

        envoiceProduct.setEnvoice(envoice);
        envoiceProduct.setProduct(product);

        return envoiceProductRepository.save(envoiceProduct);
    }

    public EnvoiceProduct updateEnvoiceProduct(Long id, EnvoiceProduct envoiceProductDetails) {
        return envoiceProductRepository.findById(id).map(envoiceProduct -> {
            envoiceProduct.setEnvoice(envoiceProductDetails.getEnvoice());
            envoiceProduct.setProduct(envoiceProductDetails.getProduct());
            envoiceProduct.setQuantity(envoiceProductDetails.getQuantity());
            return envoiceProductRepository.save(envoiceProduct);
        }).orElse(null);
    }

    public boolean deleteEnvoiceProduct(Long id) {
        return envoiceProductRepository.findById(id).map(envoiceProduct -> {
            envoiceProductRepository.delete(envoiceProduct);
            return true;
        }).orElse(false);
    }

    public EnvoiceProduct associateEnvoice(Long envoiceProductId, Long envoiceId) {
        return envoiceProductRepository.findById(envoiceProductId).map(envoiceProduct -> {
            Envoice envoice = envoiceRepository.findById(envoiceId).orElse(null);
            if (envoice != null) {
                envoiceProduct.setEnvoice(envoice);
                return envoiceProductRepository.save(envoiceProduct);
            }
            return null;
        }).orElse(null);
    }

    public EnvoiceProduct associateProduct(Long envoiceProductId, Long productId) {
        return envoiceProductRepository.findById(envoiceProductId).map(envoiceProduct -> {
            Product product = productRepository.findById(productId).orElse(null);
            if (product != null) {
                envoiceProduct.setProduct(product);
                return envoiceProductRepository.save(envoiceProduct);
            }
            return null;
        }).orElse(null);
    }

    public EnvoiceProductDTO convertToDTO(EnvoiceProduct envoiceProduct) {
        EnvoiceProductDTO dto = new EnvoiceProductDTO();
        dto.setId(envoiceProduct.getId());
        dto.setEnvoice_Id(envoiceProduct.getEnvoice().getId_envoice());
        dto.setId_product(envoiceProduct.getProduct().getId_product());
        dto.setQuantity(envoiceProduct.getQuantity());
        return dto;
    }

    public EnvoiceProduct convertToEntity(EnvoiceProductDTO dto) {
        EnvoiceProduct envoiceProduct = new EnvoiceProduct();
        envoiceProduct.setId(dto.getId());

        Envoice envoice = envoiceRepository.findById(dto.getEnvoice_Id()).orElseThrow(() -> new IllegalArgumentException("Invalid envoice ID"));
        envoiceProduct.setEnvoice(envoice);

        Product product = productRepository.findById(dto.getId_product()).orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));
        envoiceProduct.setProduct(product);

        envoiceProduct.setQuantity(dto.getQuantity());
        return envoiceProduct;
    }
}


