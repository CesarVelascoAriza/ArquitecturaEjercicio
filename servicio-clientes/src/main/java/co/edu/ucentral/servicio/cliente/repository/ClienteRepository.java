package co.edu.ucentral.servicio.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ucentral.commons.venta.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("select c from Cliente c inner join Venta v on v.cliente = c.id where  v.cliente.id = ?1")
	public Cliente findClientesByVentaById(Long id);
}
