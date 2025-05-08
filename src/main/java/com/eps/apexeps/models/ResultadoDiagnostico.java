package com.eps.apexeps.models;

import java.util.List;

// Resultado de la cita (agenda) y diagnosticos generados
public class ResultadoDiagnostico {
    private Long id_agenda;
    private String resultado_agenda;
    private List<Genera> diagnosticos;

    public Long getAgendaId() {
        return id_agenda;
    }

    public void setAgendaId(Long id_agenda) {
        this.id_agenda = id_agenda;
    }

    public String getResultadoAgenda() {
        return resultado_agenda;
    }

    public void setResultadoAgenda(String resultado_agenda) {
        this.resultado_agenda = resultado_agenda;
    }

    public List<Genera> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(List<Genera> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }
}
