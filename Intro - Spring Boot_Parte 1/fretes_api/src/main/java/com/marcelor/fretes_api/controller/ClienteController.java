package com.marcelor.fretes_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

import javax.validation.Valid;

import java.net.URI;

import com.marcelor.fretes_api.model.Cliente;
import com.marcelor.fretes_api.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> cadastro(@RequestBody @Valid Cliente cliente, UriComponentsBuilder builder) {
        final Cliente clienteSalvo = clienteService.salva(cliente);

        final URI uri = builder.path("/clientes/{id}").buildAndExpand(clienteSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(clienteSalvo);
    }

    @GetMapping
    public Iterable<Cliente> lista(String nome) {
        if (nome == null) {
            return clienteService.todos();
        } else {
            return clienteService.buscarPor(nome);
        }
    }

    /*
     * @GetMapping public Cliente buscarPor(@RequestParam(name = "id") Long id) {
     * return clienteService.buscarPor(id); }
     */

    /*
     * Versão 1
     * 
     * @GetMapping("/{id}") public Cliente buscarPor(@PathVariable Long id) { return
     * clienteService.buscarPor(id); }
     */

    // Versão 2
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscaPor(@PathVariable Long id) {
        Optional<Cliente> optional = clienteService.buscarPor(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get()); // retorna codigo 200
        } else {
            return ResponseEntity.notFound().build(); // retorna codigo 400
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualiza(@RequestBody Cliente cliente, @PathVariable Long id) {
        Optional<Cliente> optional = clienteService.buscarPor(id);
        if (optional.isPresent()) {
            cliente.setId(id);
            Cliente clienteAtualizado = clienteService.salva(cliente);
            return ResponseEntity.ok(clienteAtualizado); // retorna codigo 200
        } else {
            return ResponseEntity.notFound().build(); // retorna codigo 400
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Cliente> optional = clienteService.buscarPor(id);

        if (optional.isPresent()) {
            clienteService.removePelo(id);
            return ResponseEntity.noContent().build(); // retorna codigo 204
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
