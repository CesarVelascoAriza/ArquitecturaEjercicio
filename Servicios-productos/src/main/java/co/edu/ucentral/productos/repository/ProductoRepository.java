package co.edu.ucentral.productos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ucentral.common.producto.model.Producto;



public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	public List<Producto> findByPrecioAndCantidadOrderByIdDesc(Float precio, int cantidad);
	public List<Producto> findByPrecioBetween(Float precio1, Float precio2);
	public List<Producto> findByNombreIn(String[] nombre);
	
	//@Query("select p from Producto p where p.nombre =?1")
	//public Producto buscarPorNombre(String nombre);
	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> buscarPorNombre(String nombre);
}
