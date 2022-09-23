package co.edu.ucentral.servicio.servicio.venta.guia.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.common.producto.model.Producto;
import co.edu.ucentral.commons.services.service.CommonServiceImp;
import co.edu.ucentral.servicio.common.cliente.model.Cliente;
import co.edu.ucentral.servicio.servicio.venta.guia.clienteFeing.ProductoFeningCliente;
import co.edu.ucentral.servicio.servicio.venta.guia.modelo.Venta;
import co.edu.ucentral.servicio.servicio.venta.guia.repository.VentaRepository;
@Service
public class VentaServiceImpl extends CommonServiceImp<Venta, VentaRepository> implements VentaService{

	@Autowired
	private ProductoFeningCliente productoFeing;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Venta> findByCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return repository.findByCliente(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Producto> findProducto() {
		// TODO Auto-generated method stub
		return  productoFeing.listar();
	}

}
