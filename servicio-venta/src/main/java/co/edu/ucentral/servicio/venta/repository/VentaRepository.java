package co.edu.ucentral.servicio.venta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ucentral.servicio.venta.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {

	@Query("select v from  Venta v  where v.producto.id = ?1")
	public List<Venta> findVentasByProductoId(Long id);
}
