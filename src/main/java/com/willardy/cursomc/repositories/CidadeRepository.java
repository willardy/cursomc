package com.willardy.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willardy.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
