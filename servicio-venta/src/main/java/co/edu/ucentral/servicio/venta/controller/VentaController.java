package co.edu.ucentral.servicio.venta.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.commons.services.controller.CommonController;
import co.edu.ucentral.commons.venta.modelo.Venta;
import co.edu.ucentral.servicio.venta.service.VentaService;

@RestController
public class VentaController extends CommonController<Venta, VentaService> {

	@GetMapping("/producto/{id}")
	public ResponseEntity<?> buscarPorProducto(@PathVariable Long id){
		List<Venta> lista = service.findVentasByProductoId(id);
		return ResponseEntity.ok(lista);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody Venta venta){
		Optional<Venta> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Venta ventaDb = optional.get();
		
		ventaDb.setCantidad(venta.getCantidad());
		ventaDb.setValor(venta.getValor());
		ventaDb.setProducto(venta.getProducto());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(ventaDb));
	}
	
	@GetMapping("/cliente/{id}")
	public ResponseEntity<?> buscarPorCliente(@PathVariable Long id){
		List<Venta> lista = service.findVentasByClienteId(id);
		return ResponseEntity.ok(lista);
	}
}
