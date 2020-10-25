package com.willardy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.willardy.cursomc.domain.Categoria;
import com.willardy.cursomc.repositories.CategoriaRepository;
import com.willardy.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! Id:" + id + ", Tipo: " + Categoria.class.getName()));
	}
	
}
