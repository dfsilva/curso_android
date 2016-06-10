package br.com.diegosilva.smarthome.model;

import java.util.List;

/**
 * Created by 98379720172 on 10/06/2016.
 */
public class Sensor {

    private Long id;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
