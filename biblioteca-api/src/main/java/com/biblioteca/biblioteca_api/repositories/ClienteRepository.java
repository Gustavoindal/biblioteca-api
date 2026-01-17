package com.biblioteca.biblioteca_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.biblioteca_api.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
    
}