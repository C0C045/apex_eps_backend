package com.eps.apexeps.models;

import jakarta.persistence.*;

// Lista de diagnosticos generales
@Entity
@Table(name = "diagnostico")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cie_diagnostico", nullable = false)
    private String codigo;

    @Column(name = "nom_diagnostico", nullable = false)
    private String nombre;

    @Column(name = "desc_diagnostico", nullable = false)
    private String descripcion;

    // Constructores
    public Diagnostico() {
    }

    public Diagnostico(String codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
