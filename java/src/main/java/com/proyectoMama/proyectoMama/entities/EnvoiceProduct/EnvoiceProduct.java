package com.proyectoMama.proyectoMama.entities.EnvoiceProduct;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "envoice_product")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class EnvoiceProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "envoice_id")
    @Getter @Setter private Envoice envoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @Getter @Setter private Product product;

    @Getter @Setter private Long quantity; // Campo para la cantidad del producto
}


