package com.marcelor.fretes_api.service;

import java.util.Optional;

import com.marcelor.fretes_api.model.Cliente;
import com.marcelor.fretes_api.repository.ClienteRepository;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
  private final ClienteRepository clienteRepository;

  @Autowired
  public ClienteService(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  @Transactional
  public Cliente salva(Cliente cliente) {
    return this.clienteRepository.save(cliente);
  }

  public Iterable<Cliente> todos() {
    return clienteRepository.findAll();
  }

  public Iterable<Cliente> buscarPor(String nome) {
    return clienteRepository.findByNomeContaining(nome);
  }

  /*
   * Versão 1 public Cliente buscarPor(Long id) { return
   * clienteRepository.findById(id).get(); }
   */

  // Versão 2
  public Optional<Cliente> buscarPor(Long id) {
    return clienteRepository.findById(id);
  }

  @Transactional
  public void removePelo(Long id) {
    clienteRepository.deleteById(id);
  }

}
