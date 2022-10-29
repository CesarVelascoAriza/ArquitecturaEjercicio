package co.edu.ucentral.servicio.cuenta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({
	"co.edu.ucentral.common.cuenta.model",
})
public class ServicioCuentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioCuentaApplication.class, args);
	}

}
