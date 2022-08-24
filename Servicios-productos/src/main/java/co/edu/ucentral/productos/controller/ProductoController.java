package co.edu.ucentral.productos.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.edu.ucentral.commons.services.controller.CommonController;
import co.edu.ucentral.productos.model.Producto;
import co.edu.ucentral.productos.service.ProductoService;

@RestController
public class ProductoController extends CommonController<Producto, ProductoService> {

	@PostMapping("/crear-con-imagen")
	public ResponseEntity<?> crearConImageng
	(@Valid Producto producto,@RequestParam MultipartFile archivo, BindingResult result) throws IOException{
		if(!archivo.isEmpty()) {
			producto.setImagen(archivo.getBytes());
		}
		return crear(producto, result);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Producto producto, @PathVariable Long id, BindingResult result) {
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Producto> optiona = service.findById(id);
		if(!optiona.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Producto productoDb= optiona.get();
		productoDb.setNombre(producto.getNombre());
		productoDb.setPrecio(producto.getPrecio());
		productoDb.setCantidad(producto.getCantidad());
		productoDb.setEspecificacion(producto.getEspecificacion());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productoDb));
		
	}
	
	@PutMapping("/editar-con-imagen/{id}")
	public ResponseEntity<?> editarConImagen(@PathVariable Long id,Producto producto, @RequestParam MultipartFile archivo,BindingResult result) throws IOException{
		Optional<Producto> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Producto productoDb= optional.get();
		productoDb.setNombre(producto.getNombre());
		productoDb.setPrecio(producto.getPrecio());
		productoDb.setCantidad(producto.getCantidad());
		if(!archivo.isEmpty()) {
			productoDb.setImagen(archivo.getBytes());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productoDb));
	}
	
	@GetMapping("/download/img/{id}")
	public ResponseEntity<?> verImagen(@PathVariable Long id ){
		Optional<Producto> optional = service.findById(id);
		if(!optional.isPresent() || optional.get().getImagen() == null ) {
			return ResponseEntity.notFound().build();
		}
		Resource img = new ByteArrayResource(optional.get().getImagen());
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);
	}
	
	
	
	
}
