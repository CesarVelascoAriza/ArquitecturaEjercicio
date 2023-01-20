package co.edu.ucentral.servidor.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SpringSecurityConfig {

	@Autowired
	private JwtAuthenticationFilter athenticatioFilter;
	
	@Bean
	public SecurityWebFilterChain configure(ServerHttpSecurity http) {
		return http.authorizeExchange()
				.pathMatchers("/api/security/oauth/**","/api/productos/**").permitAll()
				.pathMatchers(HttpMethod.GET,"/api/productos","/api/productos/{id}","/api/usuarios").permitAll()
				.pathMatchers(HttpMethod.GET,"/api/usuarios/{id}").hasAnyRole("ADMIN","USER")
				.pathMatchers("/api/productos/**","/api/usuarios/**").hasRole("ADMIN")
				.anyExchange()
				.authenticated()
				.and()
				.addFilterAt(athenticatioFilter, SecurityWebFiltersOrder.AUTHENTICATION)
				.csrf()
				.disable()
				.build();
	}
}
