package proyecto.clase.jpa;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the aeropuerto database table.
 * 
 */
@Entity
@NamedQuery(name="Aeropuerto.findAll", query="SELECT a FROM Aeropuerto a")
public class Aeropuerto  {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String ciudad;

	private String nombre;

	//bi-directional many-to-one association to Vuelo
	@OneToMany(mappedBy="aeropuerto1")
	private Set<Vuelo> vuelos1;

	//bi-directional many-to-one association to Vuelo
	@OneToMany(mappedBy="aeropuerto2")
	private Set<Vuelo> vuelos2;

	public Aeropuerto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Vuelo> getVuelos1() {
		return this.vuelos1;
	}

	public void setVuelos1(Set<Vuelo> vuelos1) {
		this.vuelos1 = vuelos1;
	}

	public Vuelo addVuelos1(Vuelo vuelos1) {
		getVuelos1().add(vuelos1);
		vuelos1.setAeropuerto1(this);

		return vuelos1;
	}

	public Vuelo removeVuelos1(Vuelo vuelos1) {
		getVuelos1().remove(vuelos1);
		vuelos1.setAeropuerto1(null);

		return vuelos1;
	}

	public Set<Vuelo> getVuelos2() {
		return this.vuelos2;
	}

	public void setVuelos2(Set<Vuelo> vuelos2) {
		this.vuelos2 = vuelos2;
	}

	public Vuelo addVuelos2(Vuelo vuelos2) {
		getVuelos2().add(vuelos2);
		vuelos2.setAeropuerto2(this);

		return vuelos2;
	}

	public Vuelo removeVuelos2(Vuelo vuelos2) {
		getVuelos2().remove(vuelos2);
		vuelos2.setAeropuerto2(null);

		return vuelos2;
	}

}