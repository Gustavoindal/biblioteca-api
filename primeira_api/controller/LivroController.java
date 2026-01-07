package primeira_api.controller; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import primeira_api.models.Livro;
import primeira_api.services.BibliotecaService;


@RestController
@RequestMapping("/livros")
public class LivroController {
    private final BibliotecaService bibliotecaService;

    public LivroController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @GetMapping
    public List<Livro> listarLivros() {
        return bibliotecaService.listarLivros();
    }
    @GetMapping("/{ID_Livro}")
    public Livro buscarLivroPorId(@PathVariable String ID_Livro) {
        return bibliotecaService.buscarLivroPorId(ID_Livro);
    }
}
