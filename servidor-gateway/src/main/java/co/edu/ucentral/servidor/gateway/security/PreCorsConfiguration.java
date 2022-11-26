package co.edu.ucentral.servidor.gateway.security;

@EnableWebFlux
@Configuration
public class PreCorsConfiguration{

    @Bean
    public CorsWebFilter corsFilter(){
        return new CorsWebFilter()
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        Final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
        config.addAllowedMethod(HttpMethod.GET);
        config.addAllowedMethod(HttpMethod.POST);
        config.addAllowedMethod(HttpMethod.PUT);
        config.addAllowedMethod(HttpMethod.OPTIONS);
        config.addAllowedMethod(HttpMethod.DELETE);
        config.addAllowedOrigin("http://localhost:4200")
        source.registerCorsConfiguration("/**", config)
        return source;
    }




}