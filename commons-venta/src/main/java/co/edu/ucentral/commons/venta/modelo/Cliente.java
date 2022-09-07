	package co.edu.ucentral.commons.venta.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "No puede ser vacio")
	@Size(min = 2 , max = 60, message = "tiene que estar entre 2 y 60 caracteres" )
	private String nombre;
	@NotEmpty(message = "No puede ser vacio")
	@Size(min = 4 , max = 60, message = "tiene que estar entre 4 y 60 caracteres" )
	private String direccion;
	@JsonIgnoreProperties(value = {"cliente"}, allowSetters = true)
	@OneToMany(mappedBy = "cliente" , fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Venta> ventas;
	
	public Cliente() {
		this.ventas = new ArrayList<Venta>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas.clear();
		 ventas.forEach(this::addVenta);;
	}

	public void addVenta(Venta venta) {
		this.ventas.add(venta);
		venta.setCliente(this);
	} 
	public void removeVenta(Venta venta) {
		this.ventas.remove(venta);
		venta.setCliente(null);
	}
	
}
