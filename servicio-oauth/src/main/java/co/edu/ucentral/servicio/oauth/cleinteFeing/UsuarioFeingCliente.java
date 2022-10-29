package co.edu.ucentral.servicio.oauth.cleinteFeing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.ucentral.commons.usuario.model.Usuario;

@FeignClient(name = "servicio-usuarios")
public interface UsuarioFeingCliente {

	@GetMapping("/buscar-username")
	public Usuario buscarPorUserName(@RequestParam("username") String username);
}
