package co.edu.ucentral.servicio.cliente.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.commons.services.controller.CommonController;
import co.edu.ucentral.commons.venta.modelo.Cliente;
import co.edu.ucentral.commons.venta.modelo.Venta;
import co.edu.ucentral.servicio.cliente.service.ClienteService;

@RestController
public class CleinteController extends CommonController<Cliente, ClienteService> {
	

	@PutMapping("/{id}")
	public ResponseEntity<?> modificar(@PathVariable Long id,@RequestBody Cliente cliente ){
		Optional<Cliente> optional = service.findById(id);
		if(!optional.isPresent()) {
			return  ResponseEntity.notFound().build();
		}
		Cliente clienteDb= optional.get();
		clienteDb.setNombre(cliente.getNombre());
		clienteDb.setDireccion(cliente.getDireccion());
		List<Venta> eliminados= new ArrayList<Venta>();
		
		clienteDb.getVentas().forEach(vent -> {
			if(!cliente.getVentas().contains(vent)) {
				eliminados.add(vent);
			}
		});
		
		eliminados.forEach(v->{
			clienteDb.removeVenta(v);
		});
		
		clienteDb.setVentas(cliente.getVentas());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clienteDb));
	}
	
	
	@GetMapping("/ventas/{id}")
	public ResponseEntity<?> listarVentaPorCliente(@PathVariable Long id ){
		return ResponseEntity.ok().body(service.findClientesByVentaById(id));
	}
	
}
