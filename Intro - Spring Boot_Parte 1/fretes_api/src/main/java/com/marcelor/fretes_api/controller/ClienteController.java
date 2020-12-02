package com.marcelor.fretes_api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.marcelor.fretes_api.model.Cliente;
import com.marcelor.fretes_api.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public Iterable<Cliente> lista(String nome) {
        if (nome == null) {
            return clienteService.todos();
        } else {
            return clienteService.buscarPor(nome);
        }
    }

    /*
    @GetMapping
    public Cliente buscarPor(@RequestParam(name = "id") Long id) {
        return clienteService.buscarPor(id);
    }
    */

    @GetMapping("/{id}")
    public Cliente buscarPor(@PathVariable Long id) {
        return clienteService.buscarPor(id);
    }
}
