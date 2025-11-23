package com.projeto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projeto.model.TypeUser;

@Repository
public interface TypeUserRepository extends CrudRepository<TypeUser, Long> {
    public List<TypeUser> findAll();
    public List<TypeUser> findByTipoLike(String tipo);
}