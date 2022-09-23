package co.edu.ucentral.servicio.servicio.cliente.guia.service;

import org.springframework.stereotype.Service;

import co.edu.ucentral.commons.services.service.CommonServiceImp;
import co.edu.ucentral.servicio.common.cliente.model.Cliente;
import co.edu.ucentral.servicio.servicio.cliente.guia.repository.ClienteRepository;
@Service
public class ClienteServiceImpl extends CommonServiceImp<Cliente , ClienteRepository > implements ClienteService  {

}
