package com.algaworks.entregas.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.entregas.domain.model.Cliente;
import com.algaworks.entregas.domain.repository.ClienteRepository;
import com.algaworks.entregas.domain.service.CatalogoClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

//	@PersistenceContext
//	private EntityManager em;

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private CatalogoClienteService catalogoClienteService;

	@GetMapping
	public List<Cliente> listar() {
//		return em.createQuery("from Cliente", Cliente.class).getResultList();
		return clienteRepository.findAll();
	}

	@GetMapping(path = "/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		return clienteRepository.findById(clienteId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

//		return clienteRepository.findById(clienteId).map(cliente -> ResponseEntity.ok(cliente))
//				.orElse(ResponseEntity.notFound().build());

//		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//		if (cliente.isPresent()) {
//			return ResponseEntity.ok(cliente.get());
//		}
//		return ResponseEntity.notFound().build();
//	}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
//		return clienteRepository.save(cliente);
		return catalogoClienteService.salvar(cliente);
	}

	@PutMapping("/{clienteId}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @Valid @RequestBody Cliente cliente) {
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(clienteId);
//		cliente = clienteRepository.save(cliente);
		cliente = catalogoClienteService.salvar(cliente);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
//		clienteRepository.deleteById(clienteId);
		catalogoClienteService.excluir(clienteId);
		return ResponseEntity.noContent().build();
	}
}
