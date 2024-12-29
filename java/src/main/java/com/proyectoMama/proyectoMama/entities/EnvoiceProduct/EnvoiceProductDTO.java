package com.proyectoMama.proyectoMama.entities.EnvoiceProduct;

public class EnvoiceProductDTO {
    private Long id;
    private Long envoice_Id;
    private Long id_product;
    private Long quantity;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEnvoice_Id() {
        return envoice_Id;
    }

    public void setEnvoice_Id(Long envoice_Id) {
        this.envoice_Id = envoice_Id;
    }

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}



