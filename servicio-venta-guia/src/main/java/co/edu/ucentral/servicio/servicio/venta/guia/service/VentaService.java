package co.edu.ucentral.servicio.servicio.venta.guia.service;

import co.edu.ucentral.common.producto.model.Producto;
import co.edu.ucentral.commons.services.service.CommonService;
import co.edu.ucentral.servicio.common.cliente.model.Cliente;
import co.edu.ucentral.servicio.servicio.venta.guia.modelo.Venta;

public interface VentaService extends CommonService<Venta>{

	public Iterable<Venta>  findByCliente(Cliente cliente);
	public Iterable<Producto> findProducto();
}
