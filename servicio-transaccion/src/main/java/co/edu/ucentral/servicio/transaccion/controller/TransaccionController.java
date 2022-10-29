package co.edu.ucentral.servicio.transaccion.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.common.cuenta.model.Cuenta;
import co.edu.ucentral.servicio.transaccion.model.Transaccion;
import co.edu.ucentral.servicio.transaccion.service.TransaccionService;

@RestController
public class TransaccionController {

	@Autowired
	private TransaccionService service;
	

	@GetMapping()
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody Transaccion transaccion, BindingResult result) {
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Cuenta> optional = service.cuentasPorCliente(transaccion.getCliente().getNumeroDocumento(), transaccion.getCuenta().getTipoCuenta().getId());

		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		if (transaccion.getTipo().getId() == 1) {
			Cuenta clienteDb = optional.get();
			if(clienteDb.getSaldo() == 0) {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();	
			}
			Float monto = clienteDb.getSaldo() - transaccion.getMonto();
			clienteDb.setSaldo(monto);
			transaccion.setCuenta(clienteDb);
			service.actualizar(clienteDb);
		} else if (transaccion.getTipo().getId() == 2) {
			Cuenta clienteDb = optional.get();
			Float monto = clienteDb.getSaldo() + transaccion.getMonto();
			clienteDb.setSaldo(monto);
			transaccion.setCuenta(clienteDb);
			service.actualizar(clienteDb);
		} else {
			Cuenta clienteDb = optional.get();
			Float monto = clienteDb.getSaldo();
			transaccion.setMonto(monto);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(transaccion));

	}

	protected ResponseEntity<?> validar(BindingResult result) {
		Map<String, Object> errores = new HashMap<>();

		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), "el atributo " + err.getField() + " " + err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}

}
