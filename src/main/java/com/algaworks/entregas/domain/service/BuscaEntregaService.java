package com.algaworks.entregas.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.entregas.domain.exception.EntidadeNaoEncontradaExcepction;
import com.algaworks.entregas.domain.model.Entrega;
import com.algaworks.entregas.domain.repository.EntregaRepository;

@Service
public class BuscaEntregaService {

	@Autowired
	private EntregaRepository entregaRepository;

	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaExcepction("Entrega nao encontrada"));

	}
}
