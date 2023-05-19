package com.algaworks.entregas.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.entregas.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping(path = "/clientes")
	public List<Cliente> listar() {

		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Eduardo");
		cliente1.setEmail("eduardo@teste.com");
		cliente1.setTelefone("11 10101-0101");

		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Natany");
		cliente2.setEmail("natany@teste.com");
		cliente2.setTelefone("11 20202-0202");

		return Arrays.asList(cliente1, cliente2);
	}
}
