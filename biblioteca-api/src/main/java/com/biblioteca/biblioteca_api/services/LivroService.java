package com.biblioteca.biblioteca_api.services;
import com.biblioteca.biblioteca_api.exceptions.ResourceNotFoundException;
import com.biblioteca.biblioteca_api.models.Livro;
import com.biblioteca.biblioteca_api.repositories.LivroRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Livro buscarLivroPorId(long id) {
        return livroRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Livro com id " + id + " não encontrado." ));
    }

    public void deletarLivro(long id) {
        if(!livroRepository.existsById(id)) {
            throw new ResourceNotFoundException("Livro com id " + id + " não encontrado.");
        }
        livroRepository.deleteById(id);
    }
    public Livro atualizarLivro(long id, Livro livroAtualizado) {
        return livroRepository.findById(id).map(livro -> {
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
            livro.setGenero(livroAtualizado.getGenero());
            return livroRepository.save(livro);
        }).orElseThrow(() -> new ResourceNotFoundException("Cliente com id " + id + " não encontrado." ));
    }
}