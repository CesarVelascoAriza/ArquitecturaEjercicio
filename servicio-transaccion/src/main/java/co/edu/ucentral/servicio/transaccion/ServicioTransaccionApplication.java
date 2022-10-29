package co.edu.ucentral.servicio.transaccion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EntityScan({
	"co.edu.ucentral.common.cuenta.model",
	"co.edu.ucentral.servicio.transaccion.model"
})
@EnableFeignClients
public class ServicioTransaccionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioTransaccionApplication.class, args);
	}

}
