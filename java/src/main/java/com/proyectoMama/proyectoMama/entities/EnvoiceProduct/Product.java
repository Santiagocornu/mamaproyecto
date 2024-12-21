package com.proyectoMama.proyectoMama.entities.EnvoiceProduct;

import jakarta.persistence.*;
import lombok.*;

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

    // Atributo adicional para el precio del producto
    @Getter @Setter private double precio; // Precio del producto


}
