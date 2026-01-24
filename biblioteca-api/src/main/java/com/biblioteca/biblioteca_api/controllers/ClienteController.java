package com.biblioteca.biblioteca_api.controllers;

import org.springframework.web.bind.annotation.RestController; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import com.biblioteca.biblioteca_api.models.Cliente;
import com.biblioteca.biblioteca_api.services.ClienteService;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }
    @GetMapping("/{id}")
    public Cliente buscarClientePorId(@PathVariable long id) {
        return clienteService.buscarClientePorId(id);
    }
    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable long id) {
        clienteService.deletarCliente(id);
    }
    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable long id, @RequestBody Cliente clienteAtualizado) {
        return clienteService.atualizarCliente(id, clienteAtualizado);
    }

}
