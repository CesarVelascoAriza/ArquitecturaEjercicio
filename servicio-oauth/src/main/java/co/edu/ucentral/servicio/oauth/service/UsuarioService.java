package co.edu.ucentral.servicio.oauth.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.ucentral.commons.usuario.model.Usuario;
import co.edu.ucentral.servicio.oauth.cleinteFeing.UsuarioFeingCliente;

@Service
public class UsuarioService implements IUsuarioService ,UserDetailsService {

	@Autowired
	private UsuarioFeingCliente cliente;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = cliente.buscarPorUserName(username);
		if(usuario == null)
			throw new UsernameNotFoundException("Error en el login usuario no existe " + username);
		List<GrantedAuthority> autirities = usuario.getRoles().stream()
				.map(roles->new SimpleGrantedAuthority(roles.getNombre()))
				.collect(Collectors.toList());
				
		return new User(usuario.getUsername(),usuario.getPassword(),usuario.getEnabled(),true,true,true,autirities);
	}

	@Override
	public Usuario findByUsername(String username) {
		
		return cliente.buscarPorUserName(username);
	}

}
