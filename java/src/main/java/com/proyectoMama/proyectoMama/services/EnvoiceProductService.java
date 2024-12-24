package com.proyectoMama.proyectoMama.services;

import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.EnvoiceProduct;
import com.proyectoMama.proyectoMama.repositories.EnvoiceProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvoiceProductService {

    @Autowired
    private EnvoiceProductRepository envoiceProductRepository;

    public List<EnvoiceProduct> getAllEnvoiceProducts() {
        return envoiceProductRepository.findAll();
    }

    public EnvoiceProduct getEnvoiceProductById(Long id) {
        return envoiceProductRepository.findById(id).orElse(null);
    }

    public EnvoiceProduct createEnvoiceProduct(EnvoiceProduct envoiceProduct) {
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
}



