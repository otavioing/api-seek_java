package com.projeto.api;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.model.TypeUser;
import com.projeto.service.TypeUserService;

@RestController
@RequestMapping("/usuarioapi")
public class TypeUserApi {
    private TypeUserService typeUserService;

    public TypeUserApi(TypeUserService typeUserService) {
        this.typeUserService = typeUserService;
    }

    // Listar todos os tipos de usuários
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<TypeUser>> listar() {
        return new ResponseEntity<List<TypeUser>>(this.typeUserService.listar(), HttpStatus.OK);
    }

    // Buscar por id
    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<TypeUser> getPorId(@PathVariable("id") long id) {
        Optional<TypeUser> tipoOpt = this.typeUserService.getPorId(id);
        if (tipoOpt.isPresent()) {
            return new ResponseEntity<TypeUser>(tipoOpt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<TypeUser>(HttpStatus.NOT_FOUND);
        }
    }

    // Cadastrar um novo tipo de usuário
    @PostMapping
    @ResponseBody
    public ResponseEntity<TypeUser> cadastrar(@RequestBody TypeUser typeUser) {
        return new ResponseEntity<TypeUser>(this.typeUserService.salvar(typeUser), HttpStatus.CREATED);
    }
}
