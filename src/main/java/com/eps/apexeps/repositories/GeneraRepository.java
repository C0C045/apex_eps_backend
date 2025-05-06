package com.eps.apexeps.repositories;

import com.eps.apexeps.models.Genera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneraRepository extends JpaRepository<Genera, Long> {
}
