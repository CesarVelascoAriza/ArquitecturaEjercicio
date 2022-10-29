package co.edu.ucentral.servicio.cuenta.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.common.cuenta.model.Cuenta;
import co.edu.ucentral.servicio.cuenta.service.CuentaService;

@RestController
public class CuentaController {
	
	@Autowired
	private CuentaService service;
	
	
	@GetMapping("/cuenta-cliente")
	public ResponseEntity<?> cuentasClientes(@RequestParam Long cliente, @RequestParam Long cuenta){
		return ResponseEntity.ok().body( service.buscarPorClienteAndCuenta(cliente, cuenta));
	}
	
	@GetMapping()
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@PutMapping
	public ResponseEntity<?> guardar(@RequestBody Cuenta cuenta){
		Optional<Cuenta> optinal= service.cuentaId(cuenta.getId());
		if(!optinal.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Cuenta cuentaDB = optinal.get();
		cuentaDB.setSaldo(cuenta.getSaldo());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cuentaDB));
	}

	
}
