package com.proyectoMama.proyectoMama.repositories;

import com.proyectoMama.proyectoMama.entities.EnvoiceProduct.EnvoiceProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EnvoiceProductRepository extends JpaRepository<EnvoiceProduct, Long> {
}
