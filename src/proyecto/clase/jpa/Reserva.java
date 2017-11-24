package proyecto.clase.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reserva database table.
 * 
 */
@Entity
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva  {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int numAsiento;

	private float precioPagado;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="ClienteID")
	private Cliente cliente;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="UsuarioID")
	private Usuario usuario;

	//bi-directional many-to-one association to Vuelo
	@ManyToOne
	@JoinColumn(name="VueloID")
	private Vuelo vuelo;

	public Reserva() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumAsiento() {
		return this.numAsiento;
	}

	public void setNumAsiento(int numAsiento) {
		this.numAsiento = numAsiento;
	}

	public float getPrecioPagado() {
		return this.precioPagado;
	}

	public void setPrecioPagado(float precioPagado) {
		this.precioPagado = precioPagado;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vuelo getVuelo() {
		return this.vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

}