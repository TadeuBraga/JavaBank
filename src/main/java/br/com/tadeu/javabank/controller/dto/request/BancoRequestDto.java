package br.com.tadeu.javabank.controller.dto.request;

import jakarta.validation.constraints.NotEmpty;

import br.com.tadeu.javabank.model.Banco;
import io.swagger.v3.oas.annotations.media.Schema;

public record BancoRequestDto(
		@NotEmpty @Schema(description = "Nome completo do banco", example = "Banco Java LTD.") String nome,
		@NotEmpty @Schema(description = "Código Swift do Banco", example = "BANCOJAVASPO") String codigoIntenacional) {
	public Banco toModel() {
		return Banco.builder().nome(nome).codigoInternacional(codigoIntenacional).build();
	}
}
