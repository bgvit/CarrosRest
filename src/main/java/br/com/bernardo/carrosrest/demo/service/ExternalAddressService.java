package br.com.bernardo.carrosrest.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class ExternalAddressService {
    final String  API_ADDRESS = "https://viacep.com.br/ws/{cep}/json";
    RestTemplate template = new RestTemplate();
    UriComponents uri = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("viacep.com.br")
            .path("/ws")
            .build()

}
