package com.eps.apexeps.models;

import jakarta.persistence.*;

// Ordenes (Remisión o Examenes) que se realizan al finalizar una cita (agenda)
@Entity
@Table(name = "ordena")
public class Ordena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "agenda_ordena", nullable = false)
    private Long agendaId;

    @Column(name = "servicio_ordena", nullable = false)
    private String codigoServicio;

    // Constructores
    public Ordena() {
    }

    public Ordena(Long agendaId, String codigoServicio) {
        this.agendaId = agendaId;
        this.codigoServicio = codigoServicio;
    }

    // Getters y Setters
    public Long getAgendaId() {
        return agendaId;
    }

    public void setAgendaId(Long agendaId) {
        this.agendaId = agendaId;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }
}
