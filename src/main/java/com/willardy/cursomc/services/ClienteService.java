package com.willardy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.willardy.cursomc.domain.Cliente;
import com.willardy.cursomc.repositories.ClienteRepository;
import com.willardy.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Integer id) {

		 Optional<Cliente> cliente =  clienteRepository.findById(id);
		 
		 return cliente.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado!!! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
