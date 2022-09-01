package co.edu.ucentral.servicio.venta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.commons.venta.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
