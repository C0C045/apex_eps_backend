package com.eps.apexeps.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eps.apexeps.models.Agenda;
import com.eps.apexeps.models.Diagnostico;
import com.eps.apexeps.models.ResultadoDiagnostico;
import com.eps.apexeps.models.Genera;
import com.eps.apexeps.models.Medicamento;
import com.eps.apexeps.models.Ordena;

import com.eps.apexeps.repositories.AgendaRepository;
import com.eps.apexeps.repositories.GeneraRepository;
import com.eps.apexeps.repositories.MedicamentoRepository;
import com.eps.apexeps.repositories.OrdenaRepository;
import com.eps.apexeps.repositories.DiagnosticoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resultados")
public class ResultadoController {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private GeneraRepository generaRepository;

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Autowired
    private OrdenaRepository ordenaRepository;

    // Obtener las citas (agenda) en estado PENDIENTE de un paciente
    @GetMapping("/citas")
    public List<Agenda> getCitasPaciente(@RequestParam Integer paciente) {
        return agendaRepository.findByPacienteIdAndEstado(paciente, "PENDIENTE");
    }

    // Obtener lista de diagnosticos
    @GetMapping("/lista-diagnosticos")
    public List<Diagnostico> getListaDiagnosticos() {
        return diagnosticoRepository.findAll();
    }

    // Obtener lista de medicamentos
    @GetMapping("/lista-medicamentos")
    public List<Medicamento> getListaMedicamentos() {
        return medicamentoRepository.findAll();
    }

    // Actualizar resultado de la cita (agenda) y registrar diagnosticos
    @PostMapping("/actualizar-resultado")
    public ResponseEntity<String> actualizarResultadoYGenerarDiagnosticos(@RequestBody ResultadoDiagnostico dto) {
        Optional<Agenda> resultadoOptional = agendaRepository.findById(dto.getAgendaId());

        if (resultadoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Agenda resultado = resultadoOptional.get();
        resultado.setResultado(dto.getResultadoAgenda());
        agendaRepository.save(resultado);

        for (Genera diag : dto.getDiagnosticos()) {
            Genera nuevoGenera = new Genera(resultado.getId(), diag.getDiagnostico(), diag.getObservacion());
            generaRepository.save(nuevoGenera);
        }

        return ResponseEntity.ok("Resultado actualizado y diagnósticos registrados correctamente.");
    }

    // Crear las ordenes (Resmisión o Examen) asociadas a una cita (agenda)
    @PostMapping("/ordenes")
    public List<Ordena> crearOrden(@RequestBody List<Ordena> ordenes) {
        return ordenaRepository.saveAll(ordenes);
    }

    // Creación de formulas y su detalle asociadas a una cita (agenda)

    // Obtener todas citas de paciente (agenda)
    // @GetMapping
    // public List<Agenda> getAllResultados() {
    // return resultadoRepository.findAll();
    // }

    // // Obtener un resultado por ID
    // @GetMapping("/{id}")
    // public ResponseEntity<Agenda> getResultadoById(@PathVariable Long id) {
    // Optional<Agenda> resultado = resultadoRepository.findById(id);
    // return resultado.map(ResponseEntity::ok)
    // .orElseGet(() -> ResponseEntity.notFound().build());
    // }

    // // Crear nuevo resultado
    // @PostMapping
    // public Agenda createResultado(@RequestBody Agenda resultado) {
    // return resultadoRepository.save(resultado);
    // }

    // // Actualizar un resultado existente
    // @PutMapping("/{id}")
    // public ResponseEntity<Agenda> updateResultado(@PathVariable Long id,
    // @RequestBody Agenda updatedResultado) {
    // return resultadoRepository.findById(id).map(resultado -> {
    // resultado.setPacienteId(updatedResultado.getPacienteId());
    // resultado.setTrabajaId(updatedResultado.getTrabajaId());
    // resultado.setFechaAgenda(updatedResultado.getFechaAgenda());
    // resultado.setFechaPago(updatedResultado.getFechaPago());
    // resultado.setResultado(updatedResultado.getResultado());
    // resultado.setEstado(updatedResultado.getEstado());
    // return ResponseEntity.ok(resultadoRepository.save(resultado));
    // }).orElseGet(() -> ResponseEntity.notFound().build());
    // }

    // // Eliminar un resultado
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteResultado(@PathVariable Long id) {
    // if (resultadoRepository.existsById(id)) {
    // resultadoRepository.deleteById(id);
    // return ResponseEntity.noContent().build();
    // }
    // return ResponseEntity.notFound().build();
    // }
}
