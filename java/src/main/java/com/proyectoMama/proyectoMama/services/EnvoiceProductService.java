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

    public List<EnvoiceProduct> findAll() {
        return envoiceProductRepository.findAll();
    }

    public Optional<EnvoiceProduct> findById(Long id) {
        return envoiceProductRepository.findById(id);
    }

    public EnvoiceProduct save(EnvoiceProduct envoiceProduct) {
        return envoiceProductRepository.save(envoiceProduct);
    }

    public void deleteById(Long id) {
        envoiceProductRepository.deleteById(id);
    }
}

