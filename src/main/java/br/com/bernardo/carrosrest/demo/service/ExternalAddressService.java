package br.com.bernardo.carrosrest.demo.service;

import br.com.bernardo.carrosrest.demo.dto.AddressDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalAddressService {

    public static final String API_URL = "https://viacep.com.br/ws/";
    public static final String TYPE_SEARCH = "/json/";

    public AddressDTO getAdressFromAPISynchronously(String cep){
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<AddressDTO> responseEntity = restTemplate
        .exchange(API_URL + cep + TYPE_SEARCH, HttpMethod.GET, null, new ParameterizedTypeReference<AddressDTO>() {});

        return (responseEntity.getBody());
    }
//    public AddressDTO getAdressFromAPIAsynchronously(String cep) {
//
//    }
}
