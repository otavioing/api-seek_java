package com.projeto.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projeto.model.Usuario;
import com.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService implements org.springframework.security.core.userdetails.UserDetailsService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getAuthorities());
    }
}