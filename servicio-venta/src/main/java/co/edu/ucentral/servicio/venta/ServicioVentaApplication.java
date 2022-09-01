package co.edu.ucentral.servicio.venta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({
	"co.edu.ucentral.common.producto.model",
	"co.edu.ucentral.commons.venta.modelo"
})
public class ServicioVentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioVentaApplication.class, args);
	}

}
