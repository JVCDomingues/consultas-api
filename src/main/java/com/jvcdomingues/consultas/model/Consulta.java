package com.jvcdomingues.consultas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String especialidade;
    private String medico;

    @JsonFormat(pattern="dd-MM-yyy HH:mm:ss")
    @DateTimeFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private LocalDateTime data;
    private String local;

    public Consulta() {}

    public Consulta(Long id, String especialidade, String medico, LocalDateTime data, String local) {
        this.id = id;
        this.especialidade = especialidade;
        this.medico = medico;
        this.data = data;
        this.local = local;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
