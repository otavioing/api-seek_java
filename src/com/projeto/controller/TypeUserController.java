package com.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.projeto.model.TypeUser;
import com.projeto.report.Relatorio;
import com.projeto.service.TypeUserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TypeUserController {
    private TypeUserService typeUserService;

    public TypeUserController(TypeUserService typeUserService) {
        this.typeUserService = typeUserService;
    }

    @GetMapping("/cadastrartipo")
    public String cadastrar(Model model){
        return "cadastrartipo.jsp";
    }

    @PostMapping("/cadastrartipo")
    public String cadastrar(@ModelAttribute("typeUser") TypeUser typeUser, Model model) {

        if("professor".equals(typeUser.getTipo())) {
            typeUser.setCnpj(null);
            typeUser.setRazaoSocial(null);
        } else if ("empresa".equals(typeUser.getTipo())) {
            typeUser.setDepartamento(null);
            typeUser.setFormAcad(null);
        } else {
            typeUser.setDepartamento(null);
            typeUser.setFormAcad(null);
            typeUser.setCnpj(null);
            typeUser.setRazaoSocial(null);
        }

        TypeUser novoTipo = typeUserService.salvar(typeUser);
        model.addAttribute("texto", "Tipo cadastrado com sucesso! Código: " + novoTipo.getId());
        return "mensagem.jsp";
    }

    @GetMapping("/listartipo")
    public String listar(Model model) {
        model.addAttribute("listarTypeUser", this.typeUserService.listar());
        return "listartipo.jsp";
    }

    @GetMapping("/alterartipo")
    public String alterar(HttpServletRequest req, Model model) {
        long id = Long.valueOf(req.getParameter("id"));
        Optional<TypeUser> tipoOpt = this.typeUserService.getPorId(id);
        if (tipoOpt.isPresent()) {
            model.addAttribute("tipo", tipoOpt.get());
            return "alterartipo.jsp";
        } else {
            model.addAttribute("texto", "Tipo de usuário não encontrado.");
            return "mensagem.jsp";
        }
    }

    @PostMapping("/alterartipo")
    public String alterar(@ModelAttribute("typeUser") TypeUser typeUser, Model model) {
        TypeUser atualizadoTipo = typeUserService.salvar(typeUser);
        model.addAttribute("texto", "Tipo alterado com sucesso! Código: " + atualizadoTipo.getId());
        return "mensagem.jsp";
    }

    // @Secured("ROLE_ADMIN")
    @GetMapping("/excluirtipo")
    public String excluir(HttpServletRequest req, Model model) {
        long id = Long.valueOf(req.getParameter("id"));
        Optional<TypeUser> tipoOpt = this.typeUserService.getPorId(id);
        if (tipoOpt.isPresent()) {
            this.typeUserService.excluir(id);
            model.addAttribute("texto", "Tipo de usuário excluído com sucesso.");
        } else {
            model.addAttribute("texto", "Tipo de usuário não encontrado.");
        }
        return "mensagem.jsp";
    }

    @GetMapping("/pesquisartipo")
    public String pesquisar(HttpServletRequest req, Model model) {
        String tipo = "%"+ req.getParameter("tipo") +"%";
        model.addAttribute("listarTypeUser", this.typeUserService.pesquisarPorTipo(tipo));
        return "listartipo.jsp";
    }

    @GetMapping("/gerarrelatorio")
    public ResponseEntity<byte[]> gerar() {
        List<TypeUser> lista = this.typeUserService.listar();

        return Relatorio.gerar(
            lista,
            "Relatório de tipos de usuário",
            "Lista completa de tipos dos usuários cadastrados.",
            true
        );
    }
}
