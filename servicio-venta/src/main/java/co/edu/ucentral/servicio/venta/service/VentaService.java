package co.edu.ucentral.servicio.venta.service;

import java.util.List;

import co.edu.ucentral.commons.services.service.CommonService;
import co.edu.ucentral.commons.venta.modelo.Venta;

public interface VentaService extends CommonService<Venta>{
	
	
	public List<Venta> findVentasByProductoId(Long id);
	public List<Venta> findVentasByClienteId(Long id );

}
