package br.com.bernardo.carrosrest.demo.dto;

import br.com.bernardo.carrosrest.demo.domain.Carro;
import br.com.bernardo.carrosrest.demo.mapper.CarroMapper;
import br.com.bernardo.carrosrest.demo.mapper.CarroMapperImpl;

public class CarroDTO {

    private Long id;
    private String nome;
    private String tipo;

    public CarroDTO(){
    }

    public CarroDTO(Carro carroDTO) {
        this.id = carroDTO.getId();
        this.nome = carroDTO.getNome();
        this.tipo = carroDTO.getTipo();
    }

    public CarroDTO create(Carro carro) {
        CarroMapper carroMapper = new CarroMapperImpl();
        return carroMapper.toCarroDTO(carro);
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
