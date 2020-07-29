package br.com.bernardo.carrosrest.demo.service;

import org.springframework.stereotype.Service;


@Service
public class ExternalAddressService {
    final String  API_ADDRESS = "https://viacep.com.br/ws/{cep}/json";

}
