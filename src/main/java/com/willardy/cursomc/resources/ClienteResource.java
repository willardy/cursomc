package com.willardy.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.willardy.cursomc.domain.Cliente;
import com.willardy.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ResponseEntity<Cliente> find(@PathVariable Integer id){
		Cliente cliente = clienteService.find(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}
}
