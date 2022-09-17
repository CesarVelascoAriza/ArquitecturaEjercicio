package co.edu.ucentral.servicio.usuario.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucentral.commons.services.controller.CommonController;
import co.edu.ucentral.servicio.usuario.modelo.Usuario;
import co.edu.ucentral.servicio.usuario.service.UsuarioService;
@RestController
public class UsuarioController extends CommonController<Usuario, UsuarioService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@Valid @RequestBody Usuario usuario, @PathVariable Long id, BindingResult result){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Usuario> optional= service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Usuario usuarioDb = optional.get();
		
		usuarioDb.setNombre(usuario.getNombre());
		usuarioDb.setApellido(usuario.getApellido());
		usuarioDb.setEmail(usuario.getEmail());
		usuarioDb.setUsername(usuario.getUsername());
		usuarioDb.setPassword(usuario.getPassword());
		usuarioDb.setEnabled(usuario.getEnabled());
		usuarioDb.setRoles(usuario.getRoles());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuarioDb));
	}
}
