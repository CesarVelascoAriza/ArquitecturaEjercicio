package co.edu.ucentral.servicio.cuenta.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.common.cuenta.model.Cuenta;
import co.edu.ucentral.servicio.cuenta.repository.CuentaRepository;
@Service
public class CuentaServiceImp implements CuentaService {

	@Autowired
    private CuentaRepository repository;
	@Override
	public Optional<Cuenta> buscarPorClienteAndCuenta(Long cliente, Long cuenta) {
		// TODO Auto-generated method stub
		return repository.findByClienteNumeroDocumentoAndTipoCuentaId(cliente, cuenta);
	}
	@Override
	public Iterable<Cuenta> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	@Override
	public Cuenta save(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return repository.save(cuenta);
	}
	@Override
	public Optional<Cuenta> cuentaId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
	
	

}
