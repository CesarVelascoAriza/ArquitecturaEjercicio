package co.edu.ucentral.productos.service;

import org.springframework.stereotype.Service;

import co.edu.ucentral.common.producto.model.Producto;
import co.edu.ucentral.commons.services.service.CommonServiceImp;

import co.edu.ucentral.productos.repository.ProductoRepository;

@Service
public class ProductoServiceImp extends CommonServiceImp<Producto, ProductoRepository> implements ProductoService{

}
