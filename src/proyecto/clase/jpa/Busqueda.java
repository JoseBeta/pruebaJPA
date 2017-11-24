package proyecto.clase.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the busqueda database table.
 * 
 */
@Entity
@NamedQuery(name="Busqueda.findAll", query="SELECT b FROM Busqueda b")
public class Busqueda  {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String destino;

	private String salida;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="UsuarioID")
	private Usuario usuario;

	public Busqueda() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getSalida() {
		return this.salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}