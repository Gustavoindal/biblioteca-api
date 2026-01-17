package com.biblioteca.biblioteca_api.services;
import com.biblioteca.biblioteca_api.models.Cliente;
import com.biblioteca.biblioteca_api.repositories.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(String id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void deletarCliente(String id) {
        clienteRepository.deleteById(id);
    }

    public Cliente atualizarCliente(String id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNome(clienteAtualizado.getNome());
            return clienteRepository.save(cliente);
        }).orElse(null);
    }
    
}