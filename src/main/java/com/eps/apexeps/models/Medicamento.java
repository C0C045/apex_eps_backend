package com.eps.apexeps.models;

import jakarta.persistence.*;

// Lista de diagnosticos generales
@Entity
@Table(name = "medicamento")
public class Medicamento {

    @Id
    @Column(name = "id_medicamento")
    private String id;

    @Column(name = "nom_medicamento", nullable = false)
    private String nombre;

    // Constructores
    public Medicamento() {
    }

    public Medicamento(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
