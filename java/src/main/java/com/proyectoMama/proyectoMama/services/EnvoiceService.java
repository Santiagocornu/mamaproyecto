package com.proyectoMama.proyectoMama.services;


import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.Envoice;
import com.proyectoMama.proyectoMama.entities.Person.Client;
import com.proyectoMama.proyectoMama.entities.Person.Employer;
import com.proyectoMama.proyectoMama.repositories.ClientRepository;
import com.proyectoMama.proyectoMama.repositories.EmployerRepository;
import com.proyectoMama.proyectoMama.repositories.EnvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvoiceService {

    @Autowired
    private EnvoiceRepository envoiceRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EmployerRepository employerRepository;

    public List<Envoice> getAllEnvoices() {
        return envoiceRepository.findAll();
    }

    public Optional<Envoice> getEnvoiceById(Long id) {
        return envoiceRepository.findById(id);
    }

    public Envoice createEnvoice(Envoice envoice) {
        return envoiceRepository.save(envoice);
    }

    public Optional<Envoice> updateEnvoice(Long id, Envoice envoiceDetails) {
        return envoiceRepository.findById(id).map(envoice -> {
            envoice.setNombre_envoice(envoiceDetails.getNombre_envoice());
            envoice.setMedioPago_envoice(envoiceDetails.getMedioPago_envoice());
            envoice.setTotal_envoice(envoiceDetails.getTotal_envoice());
            envoice.setEnvoiceProducts(envoiceDetails.getEnvoiceProducts());
            envoice.setSale(envoiceDetails.getSale());
            envoice.setClient(envoiceDetails.getClient());
            envoice.setEmployer(envoiceDetails.getEmployer());
            return envoiceRepository.save(envoice);
        });
    }

    public boolean deleteEnvoice(Long id) {
        return envoiceRepository.findById(id).map(envoice -> {
            envoiceRepository.delete(envoice);
            return true;
        }).orElse(false);
    }

    public Envoice associateClient(Long envoiceId, Long clientId) {
        return envoiceRepository.findById(envoiceId).map(envoice -> {
            Client client = clientRepository.findById(clientId).orElse(null);
            if (client != null) {
                envoice.setClient(client);
                return envoiceRepository.save(envoice);
            }
            return null;
        }).orElse(null);
    }



    public Envoice associateEmployer(Long envoiceId, Long employerId) {
        return envoiceRepository.findById(envoiceId).map(envoice -> {
            Employer employer = employerRepository.findById(employerId).orElse(null);
            if (employer != null) {
                envoice.setEmployer(employer);
                return envoiceRepository.save(envoice);
            }
            return null;
        }).orElse(null);
    }
}




