package co.edu.ucentral.servicio.servicio.cliente.guia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan({
	"co.edu.ucentral.servicio.common.cliente.model"
})
@EnableEurekaClient
public class ServicioClienteGuiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioClienteGuiaApplication.class, args);
	}

}
