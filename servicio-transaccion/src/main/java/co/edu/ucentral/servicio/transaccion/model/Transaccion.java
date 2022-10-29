package co.edu.ucentral.servicio.transaccion.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Positive;

import co.edu.ucentral.common.cuenta.model.Cliente;
import co.edu.ucentral.common.cuenta.model.Cuenta;
import co.edu.ucentral.common.cuenta.model.TipoTransaccion;

@Entity
@Table(name = "Transacciones")
public class Transaccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	@ManyToOne
	@JoinColumn(name = "tipo_id")
	private TipoTransaccion tipo;
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cuenta_id",referencedColumnName = "id")
	private Cuenta cuenta;
	@Positive(message = "no puede ser negativo " )
	private Float monto;
	
	
	@PrePersist
	public void prePersist() {
		fechaCreacion = new Date();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public TipoTransaccion getTipo() {
		return tipo;
	}


	public void setTipo(TipoTransaccion tipo) {
		this.tipo = tipo;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Cuenta getCuenta() {
		return cuenta;
	}


	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}


	public Float getMonto() {
		return monto;
	}


	public void setMonto(Float monto) {
		this.monto = monto;
	}
	
	
	
	

}
