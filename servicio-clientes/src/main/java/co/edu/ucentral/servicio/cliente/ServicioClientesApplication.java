package co.edu.ucentral.servicio.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan({
	"co.edu.ucentral.common.producto.model",
	"co.edu.ucentral.commons.venta.modelo"
})
@EnableEurekaClient
public class ServicioClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioClientesApplication.class, args);
	}

}
