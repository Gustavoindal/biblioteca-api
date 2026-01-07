package primeira_api.controller;
import org.springframework.web.bind.annotation.RestController; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import primeira_api.models.Cliente;
import primeira_api.services.BibliotecaService;


@RestController
@RequestMapping("/Clientes")
public class ClienteController {
    private final BibliotecaService bibliotecaService;

    public ClienteController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return bibliotecaService.listarClientes();
    }
    @GetMapping("/{ID_Cliente}")
    public Cliente buscarClientePorId(@PathVariable String ID_Cliente) {
        return bibliotecaService.buscarClientePorId(ID_Cliente);
    }

}