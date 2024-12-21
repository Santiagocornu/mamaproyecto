package com.proyectoMama.proyectoMama.controllers;

import com.proyectoMama.proyectoMama.entities.Person.Employer;
import com.proyectoMama.proyectoMama.services.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @GetMapping
    public List<Employer> getAllEmployers() {
        return employerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employer> getEmployerById(@PathVariable Long id) {
        Optional<Employer> employer = employerService.findById(id);
        return employer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Employer createEmployer(@RequestBody Employer employer) {
        return employerService.save(employer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employer> updateEmployer(@PathVariable Long id, @RequestBody Employer employerDetails) {
        Optional<Employer> employer = employerService.findById(id);
        if (employer.isPresent()) {
            Employer updatedEmployer = employer.get();
            updatedEmployer.setNombre_person(employerDetails.getNombre_person());
            updatedEmployer.setApellido_person(employerDetails.getApellido_person());
            updatedEmployer.setTelefono_person(employerDetails.getTelefono_person());
            updatedEmployer.setLegajo_Employer(employerDetails.getLegajo_Employer());
            updatedEmployer.setGmail_Employer(employerDetails.getGmail_Employer());
            updatedEmployer.setTurno_Employer(employerDetails.getTurno_Employer());
            return ResponseEntity.ok(employerService.save(updatedEmployer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployer(@PathVariable Long id) {
        if (employerService.findById(id).isPresent()) {
            employerService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

