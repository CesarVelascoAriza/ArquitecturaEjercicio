package co.edu.ucentral.servicio.venta.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.servicio.venta.model.Cliente;
import co.edu.ucentral.servicio.venta.model.Venta;
import co.edu.ucentral.servicio.venta.service.ClienteService;
import co.edu.ucentral.servicio.venta.service.VentaService;

@RestController
public class VentaController {

	@Autowired
	private VentaService service;
	@Autowired
	private ClienteService clienteServ;
	
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Venta venta){
		Venta ventaDb = service.save(venta);
		return ResponseEntity.status(HttpStatus.CREATED).body(ventaDb);
	}
	
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<?> buscarPorProducto(@PathVariable Long id){
		List<Venta> lista = service.findVentasByProductoId(id);
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/cliente/{id}")
	public ResponseEntity<?> buscarPorClienteId(@PathVariable Long id){
		Optional<Cliente> lista = clienteServ.findById(id);
		return ResponseEntity.ok(lista);
	}
	
	@PutMapping("/cliente/{id}")
	public ResponseEntity<?> modificar(@PathVariable Long id,@RequestBody Cliente cliente ){
		Optional<Cliente> optional = clienteServ.findById(id);
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
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteServ.save(clienteDb));
	} 
	
}
