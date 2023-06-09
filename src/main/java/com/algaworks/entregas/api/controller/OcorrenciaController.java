package com.algaworks.entregas.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.entregas.api.mapper.OcorrenciaMapper;
import com.algaworks.entregas.api.model.OcorrenciaModel;
import com.algaworks.entregas.api.model.input.OcorrenciaInput;
import com.algaworks.entregas.domain.model.Entrega;
import com.algaworks.entregas.domain.model.Ocorrencia;
import com.algaworks.entregas.domain.service.BuscaEntregaService;
import com.algaworks.entregas.domain.service.RegistroOcorrenciaService;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

	@Autowired
	private RegistroOcorrenciaService registroOcorrenciaService;

	@Autowired
	private OcorrenciaMapper ocorrenciaMapper;

	@Autowired
	private BuscaEntregaService buscaEntregaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registrar(@PathVariable Long entregaId,
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId,
				ocorrenciaInput.getDescricao());
		return ocorrenciaMapper.toModel(ocorrenciaRegistrada);
	}

	@GetMapping
	public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		return ocorrenciaMapper.toColletionModel(entrega.getOcorrencias());
	}
}
