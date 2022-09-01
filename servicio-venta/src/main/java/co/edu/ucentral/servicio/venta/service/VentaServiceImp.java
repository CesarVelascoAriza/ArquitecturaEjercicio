package co.edu.ucentral.servicio.venta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.commons.venta.modelo.Venta;
import co.edu.ucentral.servicio.venta.repository.VentaRepository;

@Service
public class VentaServiceImp implements VentaService{

	@Autowired
	private VentaRepository repository;
	
	@Override
	public Iterable<Venta> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Venta> findVentasByProductoId(Long id) {
		// TODO Auto-generated method stub
		return repository.findVentasByProductoId(id);
	}

	@Override
	public Venta save(Venta venta) {
		// TODO Auto-generated method stub
		return repository.save(venta);
	}
	

}
