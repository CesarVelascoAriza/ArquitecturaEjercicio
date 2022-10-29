package co.edu.ucentral.servicio.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ServicioOauthApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ServicioOauthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String password ="1234567890";
		String passwordEncode = passwordEncoder.encode(password);
		System.out.println(passwordEncode);
		password ="13666";
		 passwordEncode = passwordEncoder.encode(password);
		System.out.println(passwordEncode);
		password ="14466";
		 passwordEncode = passwordEncoder.encode(password);
		System.out.println(passwordEncode);
		password ="153466";
		 passwordEncode = passwordEncoder.encode(password);
		System.out.println(passwordEncode);
		password ="163466";
		 passwordEncode = passwordEncoder.encode(password);
		System.out.println(passwordEncode);
		password ="173466";
		 passwordEncode = passwordEncoder.encode(password);
		System.out.println(passwordEncode);
		password ="183466";
		 passwordEncode = passwordEncoder.encode(password);
		System.out.println(passwordEncode);
		
		password ="193466";
		 passwordEncode = passwordEncoder.encode(password);
		System.out.println(passwordEncode);
		
	}

	
}
