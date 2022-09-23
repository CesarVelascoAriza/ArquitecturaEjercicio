package co.edu.ucentral.servicio.servicio.cliente.guia.controller;

import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.commons.services.controller.CommonController;
import co.edu.ucentral.servicio.common.cliente.model.Cliente;
import co.edu.ucentral.servicio.servicio.cliente.guia.service.ClienteService;

@RestController
public class ClienteController extends CommonController<Cliente, ClienteService> {

	
}
