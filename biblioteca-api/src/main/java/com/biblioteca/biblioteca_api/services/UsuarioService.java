package com.biblioteca.biblioteca_api.services;
import com.biblioteca.biblioteca_api.DTO.LoginRequest;
import com.biblioteca.biblioteca_api.models.Usuario;
import com.biblioteca.biblioteca_api.repositories.UsuarioRepository;
import com.biblioteca.biblioteca_api.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            JwtService jwtService,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager
    ) {
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public Usuario salvarUsuario(Usuario usuario) {
        usuario.setPassword(
                passwordEncoder.encode(usuario.getPassword())
        );
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorId(String id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario atualizarUsuario(String id, Usuario usuarioAtualizado) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setRole(usuarioAtualizado.getRole());
            usuario.setPassword(
                    passwordEncoder.encode(usuarioAtualizado.getPassword())
            );
            return usuarioRepository.save(usuario);
        }).orElse(null);
    }

    public void deletarUsuario(String id) {
        usuarioRepository.deleteById(id);
    }

    public String login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getSenha()
                )
        );

        Usuario usuario = usuarioRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return jwtService.generateToken(
                usuario.getEmail(),
                usuario.getRole()
        );
    }
}