package br.com.bernardo.carrosrest.demo.dto;

import br.com.bernardo.carrosrest.demo.enums.CarroColor;

import java.util.Optional;

public class CarroDTO {

    private Long id;
    private String nome;
    private String tipo;
    private CarroColor carroColor;
    private String carOwner;

    /*TODO:Manipular data em REST API, data, hora, timezone, data/hora*/
    //TODO: Fazer algum experimento que receba data no payload de um request
    //TODO: Trocar o carroColor de String para CarroColor enum para evitar o tratamento de String

    public CarroDTO(){
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

    public String getCarOwner() { return carOwner; }
    public void setCarOwner(String carOwner) { this.carOwner = carOwner; }

//    public String getCarroColor() { return carroColor; }
//    public void setCarroColor(String cor) { this.carroColor = cor; }
}
