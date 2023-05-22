package com.algaworks.entregas.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OcorrenciaModel {

	private Long id;
	private String descricao;
	private OffsetDateTime dataRegistro;
}
