package com.proyectoMama.proyectoMama.entities.EnvoiceProduct;

import com.proyectoMama.proyectoMama.entities.Person.Client;
import com.proyectoMama.proyectoMama.entities.Person.Employer;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Envoice")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Envoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id_envoice;

    @Getter @Setter private String nombre_envoice;
    @Getter @Setter private String medioPago_envoice;
    @Getter @Setter private Double total_envoice;

    // Relación uno a muchos con la clase intermedia EnvoiceProduct
    @OneToMany(mappedBy = "envoice", cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter private Set<EnvoiceProduct> envoiceProducts = new HashSet<>();

    // Relación uno a uno con Sale
    @OneToOne(mappedBy = "envoice", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @Getter @Setter private Sale sale;

    // Relación muchos a uno con Client (opcional)
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "client_id")
    @Getter @Setter private Client client;

    // Relación muchos a uno con Employer (opcional)
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "employer_id")
    @Getter @Setter private Employer employer;
}
