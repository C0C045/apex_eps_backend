package com.eps.apexeps.DTOs;
import java.util.List;

public class ResultadoDiagnosticoDTO {
    private Long resultadoId;
    private String nuevoResultadoTexto;
    private List<DiagnosticoDTO> diagnosticos;

    public Long getResultadoId() { return resultadoId; }
    public void setResultadoId(Long resultadoId) { this.resultadoId = resultadoId; }

    public String getNuevoResultadoTexto() { return nuevoResultadoTexto; }
    public void setNuevoResultadoTexto(String nuevoResultadoTexto) { this.nuevoResultadoTexto = nuevoResultadoTexto; }

    public List<DiagnosticoDTO> getDiagnosticos() { return diagnosticos; }
    public void setDiagnosticos(List<DiagnosticoDTO> diagnosticos) { this.diagnosticos = diagnosticos; }

    public static class DiagnosticoDTO {
        private String diagnostico;
        private String observacion;

        public String getDiagnostico() { return diagnostico; }
        public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

        public String getObservacion() { return observacion; }
        public void setObservacion(String observacion) { this.observacion = observacion; }
    }
}
