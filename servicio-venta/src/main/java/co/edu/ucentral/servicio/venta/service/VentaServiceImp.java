package co.edu.ucentral.servicio.venta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.ucentral.commons.services.service.CommonServiceImp;
import co.edu.ucentral.commons.venta.modelo.Venta;
import co.edu.ucentral.servicio.venta.repository.VentaRepository;

@Service
public class VentaServiceImp extends CommonServiceImp<Venta, VentaRepository> implements VentaService{

	@Override
	public List<Venta> findVentasByProductoId(Long id) {
		// TODO Auto-generated method stub
		return repository.findVentasByProductoId(id);
	}

	@Override
	public List<Venta> findVentasByClienteId(Long id) {
		// TODO Auto-generated method stub
		return repository.findVentasByClienteId(id);
	}

	
	

}
