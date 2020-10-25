package com.willardy.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.willardy.cursomc.domain.Categoria;
import com.willardy.cursomc.domain.Cidade;
import com.willardy.cursomc.domain.Cliente;
import com.willardy.cursomc.domain.Endereco;
import com.willardy.cursomc.domain.Estado;
import com.willardy.cursomc.domain.Produto;
import com.willardy.cursomc.domain.enums.TipoCliente;
import com.willardy.cursomc.repositories.CategoriaRepository;
import com.willardy.cursomc.repositories.CidadeRepository;
import com.willardy.cursomc.repositories.ClienteRepository;
import com.willardy.cursomc.repositories.EnderecoRepository;
import com.willardy.cursomc.repositories.EstadoRepository;
import com.willardy.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria("Informática");
		Categoria cat2 = new Categoria("Escritório");

		Produto p1 = new Produto("Computador", 2000.00);
		Produto p2 = new Produto("Impressora", 800.00);
		Produto p3 = new Produto("Mouse", 80.00);

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado("Minas Gerais");
		Estado est2 = new Estado("São Paulo");

		Cidade c1 = new Cidade("Uberlância", est1);
		Cidade c2 = new Cidade("São Paulo", est2);
		Cidade c3 = new Cidade("Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente("Willardy Tyrone", "willardy@gmail.com", "123.147.159.10", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("86 1234-5678", "86 9876-5432"));
		
		Endereco e1 = new Endereco("Rua X com a Y", "159-6", "01-1003", "Ininga", "64000-000", cli1, c1);
		Endereco e2 = new Endereco("Rua Y cruzando a B", "1225", "05-806", "Flores", "32564-000", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}

}
