package com.jvcdomingues.consultas.controller;

import com.jvcdomingues.consultas.model.Consulta;
import com.jvcdomingues.consultas.service.ConsultaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@Api(value = "API de consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @ApiOperation(value = "Listar todas as consultas")
    @GetMapping("/consultas")
    public List<Consulta> listarConsultas() {
        return service.listar();
    }

    @ApiOperation(value = "Criar uma nova consulta")
    @PostMapping("/consultas")
    public Consulta salvarConsulta(@RequestBody Consulta consulta) {
        return service.salvar(consulta);
    }

    @ApiOperation(value = "Atualizar uma consulta")
    @PutMapping("/consultas/{id}")
    public ResponseEntity<Consulta> atualizarConsulta(@PathVariable Long id, @RequestBody Consulta consulta) {
        return service.atualizar(id, consulta);
    }

    @ApiOperation(value = "Buscar uma consulta")
    @GetMapping("/consultas/{id}")
    public Optional<Consulta> buscarConsulta(@PathVariable Long id) {
        return service.buscar(id);
    }

    @ApiOperation(value = "Apagar uma consulta")
    @DeleteMapping("/consultas/{id}")
    public ResponseEntity<Consulta> apagarConsulta(@PathVariable Long id) {
        return service.apagar(id);
    }
}
