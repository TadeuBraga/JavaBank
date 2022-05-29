package br.com.tadeu.javabank.controller.dto.request;

import br.com.tadeu.javabank.model.Banco;
import io.swagger.v3.oas.annotations.media.Schema;

public record BancoRequestDto(
		@Schema(description = "Nome completo do banco", example = "Banco Java LTD.") String nome) {
	public Banco toModel() {
		return Banco.builder().nome(nome).build();
	}
}
