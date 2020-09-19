package com.jvcdomingues.consultas.service;

import com.jvcdomingues.consultas.model.Consulta;
import com.jvcdomingues.consultas.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    public List<Consulta> listar() {
        return repository.findAll();
    }

    public Consulta salvar(Consulta consulta) {
        return repository.save(consulta);
    }

    public Optional<Consulta> buscar(Long id) {
        return repository.findById(id);
    }

    public ResponseEntity<Consulta> atualizar(Long id, Consulta consulta) {
        Optional<Consulta> consultaOptional = repository.findById(id);

        if(!consultaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        consulta.setId(id);
        repository.save(consulta);

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Consulta> apagar(Long id) {
        Optional<Consulta> consultaOptional = repository.findById(id);

        if(!consultaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
