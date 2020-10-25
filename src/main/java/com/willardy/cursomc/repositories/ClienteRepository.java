package com.willardy.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willardy.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
