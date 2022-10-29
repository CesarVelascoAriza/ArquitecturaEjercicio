package co.edu.ucentral.servicio.cuenta.service;

import java.util.Optional;

import co.edu.ucentral.common.cuenta.model.Cuenta;

public interface CuentaService {
	
	public Iterable<Cuenta> findAll();
	public Optional<Cuenta> buscarPorClienteAndCuenta(Long cliente,Long cuenta);
	public Cuenta save(Cuenta cuenta);
	public Optional<Cuenta> cuentaId(Long id);

}
