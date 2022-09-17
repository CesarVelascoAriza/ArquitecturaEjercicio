package co.edu.ucentral.servicio.usuario.service;

import org.springframework.stereotype.Service;

import co.edu.ucentral.commons.services.service.CommonServiceImp;
import co.edu.ucentral.servicio.usuario.modelo.Usuario;
import co.edu.ucentral.servicio.usuario.repository.UsuarioRepository;
@Service
public class UsuarioServiceImp extends CommonServiceImp<Usuario, UsuarioRepository> implements UsuarioService{

}
