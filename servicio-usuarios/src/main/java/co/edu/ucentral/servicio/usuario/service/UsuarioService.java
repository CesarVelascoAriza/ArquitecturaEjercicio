package co.edu.ucentral.servicio.usuario.service;

import co.edu.ucentral.commons.services.service.CommonService;
import co.edu.ucentral.commons.usuario.model.Usuario;

public interface UsuarioService extends CommonService<Usuario> {

	public Usuario buscarPorUsername(String username);
}
