package co.edu.ucentral.servicio.venta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.servicio.venta.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
