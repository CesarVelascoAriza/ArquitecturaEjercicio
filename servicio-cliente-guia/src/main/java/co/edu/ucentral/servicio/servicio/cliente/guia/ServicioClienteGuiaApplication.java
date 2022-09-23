package co.edu.ucentral.servicio.servicio.cliente.guia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({
	"co.edu.ucentral.servicio.common.cliente.model"
})
public class ServicioClienteGuiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioClienteGuiaApplication.class, args);
	}

}
