package com.algaworks.entregas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.entregas.domain.model.Cliente;
import com.algaworks.entregas.domain.repository.ClienteRepository;

@RestController
public class ClienteController {

//	@PersistenceContext
//	private EntityManager em;

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping(path = "/clientes")
	public List<Cliente> listar() {
//		return em.createQuery("from Cliente", Cliente.class).getResultList();
		return clienteRepository.findAll();
	}

}
