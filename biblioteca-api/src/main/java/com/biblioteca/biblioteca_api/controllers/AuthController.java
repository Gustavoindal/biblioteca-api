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