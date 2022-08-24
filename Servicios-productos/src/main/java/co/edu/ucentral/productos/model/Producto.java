package co.edu.ucentral.productos.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="productos")
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	@NotEmpty(message = "No puede ser vacio")
	@Size(min = 8 , max = 40, message = "tiene que estar entre 8 y 40 caracteres" )
	@Column(length = 45)
	private String nombre;
	@Positive(message = "no puede ser negativo")
	@NotNull(message = "no puede ser vacia ")
	private int cantidad;
	@NotNull(message = "No puede  estar vacio")
	@Positive(message = "no puede ser negativo " )
	private Float precio;
	/*relaciones
	 * */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "especificacion_id")
	private EspecificacionTecnica especificacion;
	
	
	
	/*fin de la relacion 
	 * */
	@Temporal(TemporalType.DATE)
	@Column(name="create_at")
	private Date createAt;
	@Lob
	@JsonIgnore
	private byte[] imagen;
	
	
	public Producto() {
		createAt = new Date();
	}
	
	@PrePersist
	public void perPersist() {
		createAt = new Date();
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
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	public Integer getIamgenHasCode() {
		return (this.imagen != null ) ? imagen.hashCode():null;
	}

	public EspecificacionTecnica getEspecificacion() {
		return especificacion;
	}

	public void setEspecificacion(EspecificacionTecnica especificacion) {
		this.especificacion = especificacion;
	}
	
	
	
}
