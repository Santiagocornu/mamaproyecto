package com.proyectoMama.proyectoMama.entities.Person;

import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.Envoice;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Client")
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Client extends Person {

    @Getter @Setter private String Preferencia_client;

    // Relación uno a muchos con Envoice (opcional)
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter private Set<Envoice> envoices = new HashSet<>();

    // Constructor adicional
    public Client(String nombre_person, String apellido_person, String telefono_person, String Preferencia_client) {
        super(nombre_person, apellido_person, telefono_person);
        this.Preferencia_client = Preferencia_client;
    }
}
