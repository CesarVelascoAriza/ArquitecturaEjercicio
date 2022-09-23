package co.edu.ucentral.servicio.servicio.venta.guia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.servicio.common.cliente.model.Cliente;
import co.edu.ucentral.servicio.servicio.venta.guia.modelo.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {

	public Iterable<Venta> findByCliente(Cliente cliente); 
	
}
