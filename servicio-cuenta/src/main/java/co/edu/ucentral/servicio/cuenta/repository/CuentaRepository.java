package co.edu.ucentral.servicio.cuenta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.common.cuenta.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
	
	public Optional<Cuenta> findByClienteNumeroDocumentoAndTipoCuentaId(Long cliente, Long tipoCuenta);
}
