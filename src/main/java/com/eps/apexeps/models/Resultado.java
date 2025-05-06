package com.eps.apexeps.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "agenda")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agenda")
    private Long id;

    @Column(name = "paciente_agenda", nullable = false)
    private Integer pacienteId;

    @Column(name = "trabaja_agenda", nullable = false)
    private Integer trabajaId;

    @Column(name = "f_agenda", nullable = false)
    private LocalDateTime fechaAgenda;

    @Column(name = "fpago_agenda")
    private LocalDateTime fechaPago;

    @Column(name = "resultado_agenda")
    private String resultado;

    @Column(name = "estado_agenda", nullable = false)
    private String estado;

    // Constructores
    public Resultado() {}

    public Resultado(Integer pacienteId, Integer trabajaId, LocalDateTime fechaAgenda, LocalDateTime fechaPago, String resultado, String estado) {
        this.pacienteId = pacienteId;
        this.trabajaId = trabajaId;
        this.fechaAgenda = fechaAgenda;
        this.fechaPago = fechaPago;
        this.resultado = resultado;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getPacienteId() { return pacienteId; }
    public void setPacienteId(Integer pacienteId) { this.pacienteId = pacienteId; }

    public Integer getTrabajaId() { return trabajaId; }
    public void setTrabajaId(Integer trabajaId) { this.trabajaId = trabajaId; }

    public LocalDateTime getFechaAgenda() { return fechaAgenda; }
    public void setFechaAgenda(LocalDateTime fechaAgenda) { this.fechaAgenda = fechaAgenda; }

    public LocalDateTime getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDateTime fechaPago) { this.fechaPago = fechaPago; }

    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}

