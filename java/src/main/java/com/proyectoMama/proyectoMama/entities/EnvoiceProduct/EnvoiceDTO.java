package com.proyectoMama.proyectoMama.entities.EnvoiceProduct;

public class EnvoiceDTO {
        private Long id_envoice;
        private String nombre_envoice;
        private String medioPago_envoice;
        private Double total_envoice;
        private Long client_id;
        private Long employer_id;

        // Getters and setters
        public Long getId_envoice() {
            return id_envoice;
        }

        public void setId_envoice(Long id_envoice) {
            this.id_envoice = id_envoice;
        }

        public String getNombre_envoice() {
            return nombre_envoice;
        }

        public void setNombre_envoice(String nombre_envoice) {
            this.nombre_envoice = nombre_envoice;
        }

        public String getMedioPago_envoice() {
            return medioPago_envoice;
        }

        public void setMedioPago_envoice(String medioPago_envoice) {
            this.medioPago_envoice = medioPago_envoice;
        }

        public Double getTotal_envoice() {
            return total_envoice;
        }

        public void setTotal_envoice(Double total_envoice) {
            this.total_envoice = total_envoice;
        }

        public Long getClient_id() {
            return client_id;
        }

        public void setClient_id(Long client_id) {
            this.client_id = client_id;
        }
        public Long getEmployer_id() {
            return employer_id;
        }

        public void setEmployer_id(Long employer_id) {
        this.employer_id = employer_id;
        }
    }
