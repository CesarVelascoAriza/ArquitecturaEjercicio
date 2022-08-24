package co.edu.ucentral.servicio.venta.service;

import java.util.Optional;

import co.edu.ucentral.servicio.venta.model.Cliente;

public interface ClienteService {

	Iterable<Cliente> findAll();
	Optional<Cliente> findById(Long id);
	Cliente save(Cliente cliente);
	void deleteById(Long id);
}
