package co.edu.ucentral.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"co.edu.ucentral.common.producto.model"})
public class ServiciosProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiciosProductosApplication.class, args);
	}

}
