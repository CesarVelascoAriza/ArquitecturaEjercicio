package co.edu.ucentral.servicio.transaccion.service;

import java.util.Optional;

import co.edu.ucentral.common.cuenta.model.Cuenta;
import co.edu.ucentral.servicio.transaccion.model.Transaccion;

public interface TransaccionService{
	
	public Iterable<Transaccion> findAll();
	public Transaccion guardar(Transaccion transaccion);
	public Optional<Cuenta> cuentasPorCliente(Long cliente,Long tipoCuenta);
	public Cuenta actualizar(Cuenta cuenta);

}
