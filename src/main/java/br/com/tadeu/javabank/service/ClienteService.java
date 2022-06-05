package br.com.tadeu.javabank.service;

import java.util.Optional;

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

	public Optional<Cliente> findByNome(String nome) {
		return clienteRepository.findByNome(nome);
	}

	public Optional<Cliente> findByNumeroSocial(String numeroSocial) {
		return clienteRepository.findByNumeroSocial(numeroSocial);
	}

	public Cliente salvaOuObtemCliente(Cliente cliente) {
		return findByNumeroSocial(cliente.getNumeroSocial()).orElseGet(() -> clienteRepository.save(cliente));
	}
}
