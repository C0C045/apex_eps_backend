package com.eps.apexeps.models;

import jakarta.persistence.*;

@Entity
@Table(name = "genera")
public class Genera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genera")
    private Long id;

    @Column(name = "agenda_genera", nullable = false)
    private Long agendaId;

    @Column(name = "diagnostico_genera", nullable = false)
    private String diagnostico;

    @Column(name = "obs_genera")
    private String observacion;

    // Constructores
    public Genera() {}

    public Genera(Long agendaId, String diagnostico, String observacion) {
        this.agendaId = agendaId;
        this.diagnostico = diagnostico;
        this.observacion = observacion;
    }

    // Getters y Setters
    public Long getId() { return id; }

    public Long getAgendaId() { return agendaId; }
    public void setAgendaId(Long agendaId) { this.agendaId = agendaId; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }
}
