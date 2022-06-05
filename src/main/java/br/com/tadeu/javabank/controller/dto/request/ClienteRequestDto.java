package br.com.tadeu.javabank.controller.dto.request;

import br.com.tadeu.javabank.model.Cliente;
import io.swagger.v3.oas.annotations.media.Schema;

public record ClienteRequestDto(
		@Schema(description = "Nome completo do cliente", example = "João Augusto da Silva") String nome,
		@Schema(description = "CPF do cliente", example = "01974371093") String numeroSocial) {
	public Cliente toModel() {
		return Cliente.builder().nome(nome).numeroSocial(numeroSocial).build();
	}
}
