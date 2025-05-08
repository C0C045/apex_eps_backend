package com.eps.apexeps.models;

import jakarta.persistence.*;

@Entity
@Table(name = "paciente")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // o SEQUENCE si Supabase lo requiere
    private Long id;

    private String nom_paciente;
    private String email_paciente;

    // Constructores
    public User() {
    }

    public User(String nom_paciente, String email_paciente) {
        this.nom_paciente = nom_paciente;
        this.email_paciente = email_paciente;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return nom_paciente;
    }

    public void setName(String nom_paciente) {
        this.nom_paciente = nom_paciente;
    }

    public String getEmail() {
        return email_paciente;
    }

    public void setEmail(String email) {
        this.email_paciente = email;
    }
}
