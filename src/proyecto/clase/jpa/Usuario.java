package proyecto.clase.jpa;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario  {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private boolean admin;

	private String contrasena;

	@Temporal(TemporalType.DATE)
	private Date FNacimiento;

	private String nombre;

	//bi-directional many-to-one association to Busqueda
	@OneToMany(mappedBy="usuario")
	private Set<Busqueda> busquedas;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="usuario")
	private Set<Reserva> reservas;

	public Usuario() {
	}
	
	public void leer() 
	{
		DateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(getId()+"-"+getAdmin()+"-"+getContrasena()+"-"+outputFormatter.format(getFNacimiento())+"-"+getNombre());
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFNacimiento() {
		return this.FNacimiento;
	}

	public void setFNacimiento(Date FNacimiento) {
		this.FNacimiento = FNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Busqueda> getBusquedas() {
		return this.busquedas;
	}

	public void setBusquedas(Set<Busqueda> busquedas) {
		this.busquedas = busquedas;
	}

	public Busqueda addBusqueda(Busqueda busqueda) {
		getBusquedas().add(busqueda);
		busqueda.setUsuario(this);

		return busqueda;
	}

	public Busqueda removeBusqueda(Busqueda busqueda) {
		getBusquedas().remove(busqueda);
		busqueda.setUsuario(null);

		return busqueda;
	}

	public Set<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setUsuario(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setUsuario(null);

		return reserva;
	}

}