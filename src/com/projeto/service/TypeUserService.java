package com.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projeto.model.TypeUser;
import com.projeto.repository.TypeUserRepository;

@Service
public class TypeUserService {
    private TypeUserRepository typeUserRepository;

    public TypeUserService(TypeUserRepository typeUserRepository) {
        this.typeUserRepository = typeUserRepository;
    }

    public TypeUser salvar(TypeUser typeUser) {
        return this.typeUserRepository.save(typeUser);
    }

    public List<TypeUser> listar() {
        return this.typeUserRepository.findAll();
    }

    public Optional<TypeUser> getPorId(long id) {
        return this.typeUserRepository.findById(id);
    }

    public void excluir(long id) {
        this.typeUserRepository.deleteById(id);
    }

    public List<TypeUser> pesquisarPorTipo(String tipo) {
        return this.typeUserRepository.findByTipoLike(tipo);
    }
}