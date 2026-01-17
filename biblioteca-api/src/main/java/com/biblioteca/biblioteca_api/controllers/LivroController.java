package com.biblioteca.biblioteca_api.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import com.biblioteca.biblioteca_api.models.Livro;
import com.biblioteca.biblioteca_api.services.LivroService;


@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.listarLivros();
    }
    @GetMapping("/findybyid/{ID_Livro}")
    public Livro buscarLivroPorId(@PathVariable String ID_Livro) {
        return livroService.buscarLivroPorId(ID_Livro);
    }
    @DeleteMapping("/delete/{ID_Livro}")
    public void deletarLivro(@PathVariable String ID_Livro) {
        livroService.deletarLivro(ID_Livro);
    }
    @PutMapping("/update/{ID_Livro}")
    public Livro atualizarLivro(@PathVariable String ID_Livro, @RequestBody Livro livroAtualizado) {
        return livroService.atualizarLivro(ID_Livro, livroAtualizado);
    }
}
