package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="domicilio")
public class Domicilio implements Serializable{

	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name="nombre_calle")
	private String nombre_calle;
	
	@Column(name="numero")
	private int numero;
	
	@OneToOne(mappedBy="domicilio")
	private Cliente cliente;
	
	
	
	public Cliente getCliente() {
		return cliente;
	}
	
	

	Domicilio(String nombre_calle, int numero, Cliente cliente) {
		super();
		this.nombre_calle = nombre_calle;
		this.numero = numero;
		this.cliente = cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Domicilio() {
		
	}

	public Domicilio(String nombre_calle, int numero) {
		super();
		this.nombre_calle = nombre_calle;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_calle() {
		return nombre_calle;
	}

	public void setNombre_calle(String nombre_calle) {
		this.nombre_calle = nombre_calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
}
