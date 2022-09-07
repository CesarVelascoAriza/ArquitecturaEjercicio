package co.edu.ucentral.servicio.cliente.service;

import co.edu.ucentral.commons.services.service.CommonService;
import co.edu.ucentral.commons.venta.modelo.Cliente;

public interface ClienteService extends CommonService<Cliente> {

	public Cliente findClientesByVentaById(Long id);
}
