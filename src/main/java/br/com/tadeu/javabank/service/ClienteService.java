package br.com.tadeu.javabank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.tadeu.javabank.model.Cliente;
import br.com.tadeu.javabank.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@Validated
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {
	private final ClienteRepository clienteRepository;

	public Cliente findByNome(String nome) {
		return clienteRepository.findByNome(nome);
	}
}
