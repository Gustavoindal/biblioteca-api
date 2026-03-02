package com.biblioteca.biblioteca_api.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.biblioteca.biblioteca_api.DTO.LoginRequest;
import com.biblioteca.biblioteca_api.models.Usuario;
import com.biblioteca.biblioteca_api.repositories.UsuarioRepository;
import com.biblioteca.biblioteca_api.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;

    public AuthController(
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            UsuarioRepository usuarioRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/seed-users")
    public ResponseEntity<String> seedUsers() {

        List<Usuario> usuarios = List.of(
            new Usuario("usuario1@email.com", passwordEncoder.encode("senha1"), "USER"),
            new Usuario("usuario2@email.com", passwordEncoder.encode("senha2"), "ADMIN")
        );

    usuarios.forEach(usuarioRepository::save);

    return ResponseEntity.ok("Usuários inseridos com sucesso!");
}

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getSenha()
            )
        );

        Usuario usuario = usuarioRepository
                .findByEmail(request.getEmail())
                .orElseThrow();

        String token = jwtService.generateToken(
                usuario.getEmail(),
                usuario.getRole()
        );

        return ResponseEntity.ok(token);
    }
}
