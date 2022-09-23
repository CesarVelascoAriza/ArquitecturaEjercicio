package co.edu.ucentral.servicio.servicio.venta.guia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EntityScan({
	"co.edu.ucentral.common.producto.model",
	"co.edu.ucentral.servicio.common.cliente.model",
	"co.edu.ucentral.servicio.servicio.venta.guia.modelo",
})
@EnableFeignClients
public class ServicioVentaGuiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioVentaGuiaApplication.class, args);
	}

}
