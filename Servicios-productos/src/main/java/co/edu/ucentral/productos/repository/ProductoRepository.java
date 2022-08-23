package co.edu.ucentral.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.productos.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
