package co.edu.ucentral.servicio.transaccion.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.common.cuenta.model.Cuenta;
import co.edu.ucentral.servicio.transaccion.cuentaFeing.CuentaFeingCleinte;
import co.edu.ucentral.servicio.transaccion.model.Transaccion;
import co.edu.ucentral.servicio.transaccion.repository.TransaccionRepository;

@Service
public class TransaccionServiceImp implements TransaccionService {

	@Autowired
	private TransaccionRepository repository;
	@Autowired
	private CuentaFeingCleinte cuentaFeing;
	
	@Transactional
	@Override
	public Transaccion guardar(Transaccion transaccion) {
		return repository.save(transaccion);
	}

	@Override
	public Iterable<Transaccion> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	public Optional<Cuenta> cuentasPorCliente(Long cliente, Long tipoCuenta) {
		// TODO Auto-generated method stub
		return cuentaFeing.cuentasPorClienteFeing(cliente, tipoCuenta);
	}

	@Override
	public Cuenta actualizar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return cuentaFeing.actualizarCuenta(cuenta);
	}

	

}
