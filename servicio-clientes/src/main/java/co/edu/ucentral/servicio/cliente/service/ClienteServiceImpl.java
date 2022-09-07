package co.edu.ucentral.servicio.cliente.service;

import org.springframework.stereotype.Service;

import co.edu.ucentral.commons.services.service.CommonServiceImp;
import co.edu.ucentral.commons.venta.modelo.Cliente;
import co.edu.ucentral.servicio.cliente.repository.ClienteRepository;

@Service
public class ClienteServiceImpl extends CommonServiceImp<Cliente, ClienteRepository> implements ClienteService {

	@Override
	public Cliente findClientesByVentaById(Long id) {
		// TODO Auto-generated method stub
		return repository.findClientesByVentaById(id);
	}

	

}
