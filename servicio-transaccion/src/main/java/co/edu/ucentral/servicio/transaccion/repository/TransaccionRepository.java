package co.edu.ucentral.servicio.transaccion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ucentral.servicio.transaccion.model.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
	
	
	@Query("select t from Transaccion t where t.cliente.numeroDocumento =?1 and t.cuenta.id = ?2 ")
	public Optional<Transaccion> findTransaccionByClienteNumeroDocumentoAndCuentaId(Long cliente, Long id );
}
