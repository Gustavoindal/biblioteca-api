package primeira_api.services;
import java.util.List;
import org.springframework.stereotype.Service;
import primeira_api.models.Cliente;
import primeira_api.models.Livro;
import primeira_api.repositories.ClienteRepository;
import primeira_api.repositories.LivroRepository;
import jakarta.annotation.PostConstruct;


@Service
public class BibliotecaService {

    private final LivroRepository livroRepository;
    private final ClienteRepository clienteRepository;

    public BibliotecaService(LivroRepository livroRepository, ClienteRepository clienteRepository) {
        this.livroRepository = livroRepository;
        this.clienteRepository = clienteRepository;
    }

    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Livro buscarLivroPorId(String id) {
        return livroRepository.findById(id).orElse(null);
    }

    public Cliente buscarClientePorId(String id) {
        return clienteRepository.findById(id).orElse(null);
    }
    
    @PostConstruct
    public void iniciarDados() {
        // Adicionando livros iniciais
        salvarLivro(new Livro("101", "Java para Iniciantes", "Maria Souza", "2020", "Tecnologia"));
        salvarLivro(new Livro("102", "Aprendendo Spring Boot", "Carlos Lima", "2021", "Tecnologia"));

        // Adicionando clientes iniciais
        salvarCliente(new Cliente("1", "Gustavo", "gustavo@email.com"));
        salvarCliente(new Cliente("2", "Ana Pereira", "ana.pereira@email.com"));     
    }
}
