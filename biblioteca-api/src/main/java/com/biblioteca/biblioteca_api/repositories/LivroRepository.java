package com.biblioteca.biblioteca_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.biblioteca_api.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}