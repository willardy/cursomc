package com.willardy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.willardy.cursomc.domain.Pedido;
import com.willardy.cursomc.repositories.PedidoRepository;
import com.willardy.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido buscar(Integer id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		
		return pedido.orElseThrow(() -> new ObjectNotFoundException("Pedido nao encontrado: id: " + id + ", Item: " + Pedido.class.getName()));
	}
}
