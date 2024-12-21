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

    // Relación con Envoice
    @ManyToOne
    @JoinColumn(name = "envoice_id")
    @Getter @Setter private Envoice envoice;

    // Relación con Product
    @ManyToOne
    @JoinColumn(name = "product_id")
    @Getter @Setter private Product product;

    // Cantidad del producto en esta factura
    @Getter @Setter private int cantidad;

    public double getSubtotal() {
        return product.getPrecio() * cantidad; // Calcular subtotal basado en precio y cantidad.
    }
}
