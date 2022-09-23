package co.edu.ucentral.servicio.servicio.cliente.guia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.servicio.common.cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
