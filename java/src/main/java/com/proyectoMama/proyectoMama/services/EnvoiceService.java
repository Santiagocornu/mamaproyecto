package com.proyectoMama.proyectoMama.services;


import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.Envoice;
import com.proyectoMama.proyectoMama.repositories.EnvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnvoiceService {

    @Autowired
    private EnvoiceRepository envoiceRepository;

    public List<Envoice> getAllEnvoices() {
        return envoiceRepository.findAll();
    }

    public Envoice getEnvoiceById(Long id) {
        return envoiceRepository.findById(id).orElse(null);
    }

    public Envoice createEnvoice(Envoice envoice) {
        return envoiceRepository.save(envoice);
    }

    public Envoice updateEnvoice(Long id, Envoice envoiceDetails) {
        return envoiceRepository.findById(id).map(envoice -> {
            envoice.setNombre_envoice(envoiceDetails.getNombre_envoice());
            envoice.setMedioPago_envoice(envoiceDetails.getMedioPago_envoice());
            envoice.setTotal_envoice(envoiceDetails.getTotal_envoice());
            envoice.setEnvoiceProducts(envoiceDetails.getEnvoiceProducts());
            envoice.setSale(envoiceDetails.getSale());
            envoice.setClient(envoiceDetails.getClient());
            envoice.setEmployer(envoiceDetails.getEmployer());
            return envoiceRepository.save(envoice);
        }).orElse(null);
    }

    public boolean deleteEnvoice(Long id) {
        return envoiceRepository.findById(id).map(envoice -> {
            envoiceRepository.delete(envoice);
            return true;
        }).orElse(false);
    }
}



