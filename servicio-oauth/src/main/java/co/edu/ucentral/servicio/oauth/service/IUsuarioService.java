package co.edu.ucentral.servicio.oauth.service;

import co.edu.ucentral.commons.usuario.model.Usuario;

public interface IUsuarioService  {

	public Usuario findByUsername(String username);
}
