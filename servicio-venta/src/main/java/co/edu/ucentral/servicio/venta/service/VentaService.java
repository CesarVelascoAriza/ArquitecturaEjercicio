package co.edu.ucentral.servicio.venta.service;

import java.util.List;

import co.edu.ucentral.commons.venta.modelo.Venta;

public interface VentaService {
	
	public Iterable<Venta> findAll();
	public List<Venta> findVentasByProductoId(Long id);
	public Venta save(Venta venta);

}
