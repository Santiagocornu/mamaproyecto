package com.proyectoMama.proyectoMama.entities.EnvoiceProduct;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Product")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id_product;

    @Getter @Setter private String nombre_product;
    @Getter @Setter private String descripcion_product;
    @Getter @Setter private double precio;

    // Relación uno a muchos con EnvoiceProduct
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter private Set<EnvoiceProduct> envoiceProducts = new HashSet<>();
}

