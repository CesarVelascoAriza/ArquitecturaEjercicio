package co.edu.ucentral.servicio.servicio.venta.guia.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.common.producto.model.Producto;
import co.edu.ucentral.commons.services.controller.CommonController;
import co.edu.ucentral.servicio.common.cliente.model.Cliente;
import co.edu.ucentral.servicio.servicio.venta.guia.modelo.Venta;
import co.edu.ucentral.servicio.servicio.venta.guia.service.VentaService;
@RestController
public class VentaController extends CommonController<Venta, VentaService> {

	
	@GetMapping("/cliente")
	public ResponseEntity<?> listarVentasCliente(@RequestBody Cliente cliente){
		
		return ResponseEntity.ok().body(service.findByCliente(cliente));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Venta venta){
		Optional<Venta> optinal= service.findById(id);
		if(!optinal.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Venta ventaDb=optinal.get();
		ventaDb.setCantidad(venta.getCantidad());
		ventaDb.setValor(venta.getProducto().getPrecio());
		ventaDb.setCliente(venta.getCliente());
		ventaDb.setProducto(venta.getProducto());
		return  ResponseEntity.status(HttpStatus.CREATED).body(service.save(ventaDb));
		
	}
	
	@GetMapping("/productos")
	public ResponseEntity<?> buscarProductos(){
		Iterable<Producto> lista = service.findProducto();
		return ResponseEntity.ok(lista);
	}
	
}
