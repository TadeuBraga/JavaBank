package br.com.tadeu.javabank.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Builder
@JsonIgnoreProperties(value = {"stackTrace"})
public class GenericApplicationException extends Exception {
	private static final long serialVersionUID = -7499182515521838072L;
	@Builder.Default
	private final int errorCode = 500;
	private final String message;
	
	public GenericApplicationException(String message) {
		super();
		this.errorCode = 500;
		this.message = message;
	}
}