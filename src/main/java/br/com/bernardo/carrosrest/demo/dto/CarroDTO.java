package br.com.bernardo.carrosrest.demo.dto;

import br.com.bernardo.carrosrest.demo.domain.Carro;

public class CarroDTO {

    private Long id;
    private String nome;
    private String tipo;

    public CarroDTO(){
    }

    public CarroDTO(Carro c) {
        this.id = c.getId();
        this.nome = c.getNome();
        this.tipo = c.getTipo();
    }

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

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
