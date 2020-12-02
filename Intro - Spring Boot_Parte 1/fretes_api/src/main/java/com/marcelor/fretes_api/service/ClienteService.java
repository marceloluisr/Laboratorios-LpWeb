package com.marcelor.fretes_api.service;



import com.marcelor.fretes_api.model.Cliente;
import com.marcelor.fretes_api.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    

	public Iterable<Cliente> todos() {
		return clienteRepository.findAll();
    }

	public Iterable<Cliente> buscarPor(String nome) {
		return clienteRepository.findByNomeContaining(nome);
    }

    public Cliente buscarPor(Long id) {
		return clienteRepository.findById(id).get();
    }

    
    

    



}
