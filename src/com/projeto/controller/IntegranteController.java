package com.projeto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntegranteController {
    private List<String> integrantes;

    public IntegranteController() {
        this.integrantes = new ArrayList<>();
        this.integrantes.add("Bruno Ken Fugimoto");
        this.integrantes.add("Cauã Eduardo do Nascimento");
        this.integrantes.add("Francisco Carlos Amoroso Júnior");
        this.integrantes.add("João Felipe Vicente");
        this.integrantes.add("Miguel Gallerdo Lima");
        this.integrantes.add("Otávio Domingues da Silva");
    }

    @GetMapping("/integrante")
    public String integrante(Model model) {
        model.addAttribute("integrantes", this.integrantes);
        model.addAttribute("exibir", true);
        return "integrante.jsp";
    }
}
