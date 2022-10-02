package co.edu.ucentral.servicio.servicio.venta.guia.clienteFeing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.ucentral.common.producto.model.Producto;

@FeignClient(name = "servicio-producto",url = "localhost:8090/api/productos")
public interface ProductoFeningCliente {
	
	@GetMapping
	public Iterable<Producto> listar();

}
