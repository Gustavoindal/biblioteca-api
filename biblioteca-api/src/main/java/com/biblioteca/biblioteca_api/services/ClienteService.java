package com.biblioteca.biblioteca_api.services;
import com.biblioteca.biblioteca_api.exceptions.ResourceNotFoundException;
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

    public Cliente buscarClientePorId(long id) {
        return clienteRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Cliente com id " + id + " não encontrado." ));
    }

    public void deletarCliente(long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente com id " + id + " não encontrado.");
        }
        clienteRepository.deleteById(id);
    }

    public Cliente atualizarCliente(long id, Cliente clienteAtualizado) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNome(clienteAtualizado.getNome());
            return clienteRepository.save(cliente);
        }).orElseThrow(() -> new ResourceNotFoundException("Cliente com id " + id + " não encontrado." ));
    }
    
}