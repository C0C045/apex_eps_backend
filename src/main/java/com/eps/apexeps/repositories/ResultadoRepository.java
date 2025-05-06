package com.eps.apexeps.repositories;

import com.eps.apexeps.models.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
  List<Resultado> findByPacienteIdAndEstado(Integer pacienteId, String estado);
}
