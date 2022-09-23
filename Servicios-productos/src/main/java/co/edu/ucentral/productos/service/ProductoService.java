package co.edu.ucentral.productos.service;

import java.util.List;

import co.edu.ucentral.common.producto.model.Producto;
import co.edu.ucentral.commons.services.service.CommonService;


public interface ProductoService extends CommonService<Producto>{
	
	public List<Producto> buscarPorPrecioYCantidad(Float precio,int cantidad);
	public List<Producto> buscarPorPrecioEntre(Float precio1, Float precio2);
	public List<Producto> buscarPorIn(String[] nombre);
	public List<Producto> buscarPorNombre(String nombre);
	
}
