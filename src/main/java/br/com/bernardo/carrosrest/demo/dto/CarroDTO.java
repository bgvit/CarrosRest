package br.com.bernardo.carrosrest.demo.dto;

import br.com.bernardo.carrosrest.demo.domain.CarroEntity;
import br.com.bernardo.carrosrest.demo.mapper.CarroMapper;
import br.com.bernardo.carrosrest.demo.mapper.CarroMapperImpl;

import java.util.Optional;

public class CarroDTO {

    private Long id;
    private String nome;
    private String tipo;
    private String carroColor;
    private Optional<String> carOwner;

    /*TODO:Manipular data em REST API, data, hora, timezone, data/hora*/
    /*TODO:Criar um Enum de cor e manipula o enum / Ver: Ordinal / NOME*/
    /*TODO: Tratar o optional acima. Se o optional tiver um valor e esse valor for nulo*/


    public CarroDTO(){
    }

    public static CarroDTO create(CarroEntity carroEntity) {
        CarroMapper carroMapper = new CarroMapperImpl();
        return carroMapper.toCarroDTO(carroEntity);
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

    public Optional<String> getCarOwner() { return carOwner; }
    public void setCarOwner(String carOwner) {
        this.carOwner = Optional.ofNullable(carOwner); }

    public String getCarroColor() { return carroColor; }
    public void setCarroColor(String cor) { this.carroColor = cor; }
}
