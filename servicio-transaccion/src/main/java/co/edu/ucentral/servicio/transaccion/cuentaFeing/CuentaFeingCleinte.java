package co.edu.ucentral.servicio.transaccion.cuentaFeing;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.ucentral.common.cuenta.model.Cuenta;

@FeignClient(name = "servicio-cuentas",url = "localhost:8002")
public interface CuentaFeingCleinte {

	@GetMapping("/cuenta-cliente")
	public Optional<Cuenta> cuentasPorClienteFeing(@RequestParam Long cliente,@RequestParam Long cuenta);
	@PutMapping
	public Cuenta actualizarCuenta(@RequestBody Cuenta cuenta);
}
