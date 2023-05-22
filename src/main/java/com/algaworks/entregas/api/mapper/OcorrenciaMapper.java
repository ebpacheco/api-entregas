package com.algaworks.entregas.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.entregas.api.model.OcorrenciaModel;
import com.algaworks.entregas.domain.model.Ocorrencia;

@Component
public class OcorrenciaMapper {

	@Autowired
	private ModelMapper modelMapper;

	public OcorrenciaModel toModel(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaModel.class);
	}

	public List<OcorrenciaModel> toColletionModel(List<Ocorrencia> ocorrencias) {
		return ocorrencias.stream().map(this::toModel).collect(Collectors.toList());
	}
}
