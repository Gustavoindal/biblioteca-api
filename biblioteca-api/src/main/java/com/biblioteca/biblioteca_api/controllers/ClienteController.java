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
    @GetMapping("/findybyid/{ID_Cliente}")
    public Cliente buscarClientePorId(@PathVariable String ID_Cliente) {
        return clienteService.buscarClientePorId(ID_Cliente);
    }
    @DeleteMapping("/delete/{ID_Cliente}")
    public void deletarCliente(@PathVariable String ID_Cliente) {
        clienteService.deletarCliente(ID_Cliente);
    }
    @PutMapping("/update/{ID_Cliente}")
    public Cliente atualizarCliente(@PathVariable String ID_Cliente, @RequestBody Cliente clienteAtualizado) {
        return clienteService.atualizarCliente(ID_Cliente, clienteAtualizado);
    }

}
