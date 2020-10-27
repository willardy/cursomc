package com.willardy.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willardy.cursomc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
