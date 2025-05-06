package com.eps.apexeps.controllers;

import com.eps.apexeps.models.Resultado;
import com.eps.apexeps.models.Genera;
import com.eps.apexeps.DTOs.ResultadoDiagnosticoDTO;
import com.eps.apexeps.repositories.ResultadoRepository;
import com.eps.apexeps.repositories.GeneraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resultados")
public class ResultadoController {

    @Autowired
    private ResultadoRepository resultadoRepository;

    @Autowired
    private GeneraRepository generaRepository;

    // Obtener citas de paciente (Agenda)
    @GetMapping
    public List<Resultado> getAllResultados() {
        return resultadoRepository.findAll();
    }

    // Obtener un resultado por ID
    @GetMapping("/{id}")
    public ResponseEntity<Resultado> getResultadoById(@PathVariable Long id) {
        Optional<Resultado> resultado = resultadoRepository.findById(id);
        return resultado.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear nuevo resultado
    @PostMapping
    public Resultado createResultado(@RequestBody Resultado resultado) {
        return resultadoRepository.save(resultado);
    }

    // Actualizar un resultado existente
    @PutMapping("/{id}")
    public ResponseEntity<Resultado> updateResultado(@PathVariable Long id, @RequestBody Resultado updatedResultado) {
        return resultadoRepository.findById(id).map(resultado -> {
            resultado.setPacienteId(updatedResultado.getPacienteId());
            resultado.setTrabajaId(updatedResultado.getTrabajaId());
            resultado.setFechaAgenda(updatedResultado.getFechaAgenda());
            resultado.setFechaPago(updatedResultado.getFechaPago());
            resultado.setResultado(updatedResultado.getResultado());
            resultado.setEstado(updatedResultado.getEstado());
            return ResponseEntity.ok(resultadoRepository.save(resultado));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar un resultado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultado(@PathVariable Long id) {
        if (resultadoRepository.existsById(id)) {
            resultadoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/pendientes")
    public List<Resultado> getPendientesByQueryParam(@RequestParam Integer pacienteId) {
        return resultadoRepository.findByPacienteIdAndEstado(pacienteId, "PENDIENTE");
    }
    
    @PostMapping("/actualizar-resultado")
    public ResponseEntity<String> actualizarResultadoYGenerarDiagnosticos(@RequestBody ResultadoDiagnosticoDTO dto) {
        Optional<Resultado> resultadoOptional = resultadoRepository.findById(dto.getResultadoId());

        if (resultadoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Resultado resultado = resultadoOptional.get();
        resultado.setResultado(dto.getNuevoResultadoTexto());
        resultadoRepository.save(resultado);

        for (ResultadoDiagnosticoDTO.DiagnosticoDTO diag : dto.getDiagnosticos()) {
            Genera nuevoGenera = new Genera(resultado.getId(), diag.getDiagnostico(), diag.getObservacion());
            generaRepository.save(nuevoGenera);
        }

        return ResponseEntity.ok("Resultado actualizado y diagnósticos registrados correctamente.");
    }

}
