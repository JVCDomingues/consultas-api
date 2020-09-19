package com.jvcdomingues.consultas.repository;

import com.jvcdomingues.consultas.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
