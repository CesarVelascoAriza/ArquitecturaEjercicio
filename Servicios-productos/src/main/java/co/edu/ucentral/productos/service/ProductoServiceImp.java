package co.edu.ucentral.productos.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.common.producto.model.Producto;
import co.edu.ucentral.commons.services.service.CommonServiceImp;
import co.edu.ucentral.productos.repository.ProductoRepository;

@Service
public class ProductoServiceImp extends CommonServiceImp<Producto, ProductoRepository> implements ProductoService{

	
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> buscarPorPrecioYCantidad(Float precio, int cantidad) {
		// TODO Auto-generated method stub
		return repository.findByPrecioAndCantidadOrderByIdDesc(precio, cantidad);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> buscarPorPrecioEntre(Float precio1, Float precio2) {
		// TODO Auto-generated method stub
		return repository.findByPrecioBetween(precio1, precio2);
	}

	@Override
	public List<Producto> buscarPorIn(String[] nombre) {
		// TODO Auto-generated method stub
		return repository.findByNombreIn(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return repository.buscarPorNombre(nombre);
	}

	
}
