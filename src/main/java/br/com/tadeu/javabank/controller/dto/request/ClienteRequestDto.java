package br.com.tadeu.javabank.controller.dto.request;

import br.com.tadeu.javabank.model.Cliente;
import io.swagger.v3.oas.annotations.media.Schema;

public record ClienteRequestDto(
		@Schema(description = "Nome completo do cliente", example = "João Augusto da Silva") String nome) {
	public Cliente toModel() {
		return Cliente.builder().nome(nome).build();
	}
}
