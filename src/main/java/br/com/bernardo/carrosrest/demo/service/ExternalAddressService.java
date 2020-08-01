package br.com.bernardo.carrosrest.demo.service;

import br.com.bernardo.carrosrest.demo.dto.AddressDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Repository
//TODO:Pensar nisso como um resource. Pensar na ideia que o mauricio trouxe
public class ExternalAddressService {

    @Value("${api.cep.url}")
    private String API_URL;
    private static final String TYPE_SEARCH = "/json/";

    public AddressDTO getAdressFromAPISynchronously(String cep){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AddressDTO> responseEntity = restTemplate
        .exchange(API_URL + cep + TYPE_SEARCH, HttpMethod.GET, null, new ParameterizedTypeReference<AddressDTO>() {});

        return (responseEntity.getBody());
    }
//    public AddressDTO getAdressFromAPIAsynchronously(String cep) {
//
//    }
    /* QUESTÃO DESAFIO DO BANCO SENDO MASSACRADO O QUE FAZER - Implementação - Dica Spring Boot tem recurso.
     Montar Guia de Estudo
     NOVO FOCO: NodeJS API DE CRIAÇÂO, LEITURA, INTEGRAÇÂO E SOBE NO EXPRESS */

}
