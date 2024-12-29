package com.proyectoMama.proyectoMama.entities.EnvoiceProduct;

public class ProductDTO {
    private Long id_product;
    private String nombre_product;
    private String descripcion_product;
    private double precio;

    // Getters and Setters

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public String getNombre_product() {
        return nombre_product;
    }

    public void setNombre_product(String nombre_product) {
        this.nombre_product = nombre_product;
    }

    public String getDescripcion_product() {
        return descripcion_product;
    }

    public void setDescripcion_product(String descripcion_product) {
        this.descripcion_product = descripcion_product;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}


