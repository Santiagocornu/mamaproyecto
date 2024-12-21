package com.proyectoMama.proyectoMama.services;

import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.Envoice;
import com.proyectoMama.proyectoMama.repositories.EnvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvoiceService {
    @Autowired
    private EnvoiceRepository envoiceRepository;

    public List<Envoice> findAll() {
        return envoiceRepository.findAll();
    }

    public Optional<Envoice> findById(Long id) {
        return envoiceRepository.findById(id);
    }

    public Envoice save(Envoice envoice) {
        return envoiceRepository.save(envoice);
    }

    public void deleteById(Long id) {
        envoiceRepository.deleteById(id);
    }
}
