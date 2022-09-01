package co.edu.ucentral.servicio.venta.service;

import java.util.Optional;

import co.edu.ucentral.commons.venta.modelo.Cliente;

public interface ClienteService {

	Iterable<Cliente> findAll();
	Optional<Cliente> findById(Long id);
	Cliente save(Cliente cliente);
	void deleteById(Long id);
}
