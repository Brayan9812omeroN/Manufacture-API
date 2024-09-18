package com.pruebatecnica.manufactura_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status statusId;

    @ManyToOne
    @JoinColumn(name = "elaboration_id")
    private Elaboration elaborationId;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(Long id, String name, Status statusId, Elaboration elaborationId) {
        this.name = name;
        this.elaborationId = elaborationId;
    }

    
    @PrePersist
    protected void onCreate() {
        if (this.statusId == null) {
            this.statusId = new Status(1L, "Disponible");
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public Elaboration getElaborationId() {
        return elaborationId;
    }

    public void setElaborationId(Elaboration elaborationId) {
        this.elaborationId = elaborationId;
    }

    
}