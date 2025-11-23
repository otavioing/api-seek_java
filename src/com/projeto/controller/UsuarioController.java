package com.projeto.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projeto.model.Usuario;
import com.projeto.repository.UsuarioRepository;

@Controller
public class UsuarioController {

    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    public UsuarioController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/cadastrarusuario")
    public String cadastrarUsuario(@RequestParam("email") String email,
                                   @RequestParam("nome") String nome,
                                   @RequestParam("password") String password,
                                   @RequestParam("confirmPassword") String confirmPassword,
                                   Model model) {

        if (!password.equals(confirmPassword)) {
            model.addAttribute("erro", "As senhas não coincidem.");
            return "login.jsp";
        }

        if (usuarioRepository.findByEmail(email).isPresent()) {
            model.addAttribute("erro", "Usuário já existe.");
            return "login.jsp";
        }

        String senhaCriptografada = passwordEncoder.encode(password);

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(nome);
        novoUsuario.setEmail(email);
        novoUsuario.setPassword(senhaCriptografada);
        novoUsuario.setRoles("ROLE_USER");

        usuarioRepository.save(novoUsuario);

        return "redirect:/login";
    }
}