package Model.Tripulante;

import Event.PersonalRegistrado;
import core.AggregateRoot;
import java.util.UUID;

public class Tripulante extends AggregateRoot<UUID> {

	// public UUID Key;
	private String Nombre;
	private String Apellido;
	private String EmailAddress;
	private Integer Estado;
	private String Tipo;
	private Double HorasVuelo;
	private Double NroMillas;

	UUID KeyCargo;

	// private Tierra cargo_tierra;
	// private Aire cargo_aire;

	public Tripulante() {}

	public Tripulante(
		String nombre,
		String apellido,
		String emailAddress,
		// String estado,
		String tipo,
		Double horasVuelo,
		Double nroMillas,
		UUID keyCargo
	) {
		key = UUID.randomUUID();
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.EmailAddress = emailAddress;
		this.Estado = 1;
		this.Tipo = tipo;
		this.HorasVuelo = horasVuelo;
		this.NroMillas = nroMillas;
		this.KeyCargo = keyCargo;
	}

	// public Tripulante(
	// 	UUID key,
	// 	String nombre,
	// 	String apellido,
	// 	String emailAddress,
	// 	// String estado,
	// 	String tipo,
	// 	Double horasVuelo,
	// 	Double nroMillas,
	// 	Cargo cargo
	// ) {
	// 	this.key = key;
	// 	this.Nombre = nombre;
	// 	this.Apellido = apellido;
	// 	this.EmailAddress = emailAddress;
	// 	this.Estado = 1;
	// 	this.Tipo = tipo;
	// 	this.HorasVuelo = horasVuelo;
	// 	this.NroMillas = nroMillas;
	// 	this.Cargo = cargo;
	// }

	public void eventCreado() {
		addDomainEvent(new PersonalRegistrado(key, Nombre));
	}

	public UUID getKey() {
		return key;
	}

	public void setKey(UUID key) {
		this.key = key;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		this.Apellido = apellido;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.EmailAddress = emailAddress;
	}

	public Integer getEstado() {
		return Estado;
	}

	public void setEstado(Integer estado) {
		this.Estado = estado;
	}

	public String getTipo() {
		return this.Tipo;
	}

	public void setTipo(String tipo) {
		this.Tipo = tipo;
	}

	public Double getHorasVuelo() {
		return this.HorasVuelo;
	}

	public void setHorasVuelo(Double horasVuelo) {
		this.HorasVuelo = horasVuelo;
	}

	public Double getNroMillas() {
		return this.NroMillas;
	}

	public void setNroMillas(Double nroMillas) {
		this.NroMillas = nroMillas;
	}

	public UUID getKeyCargo() {
		return KeyCargo;
	}

	public void setKeyCargo(UUID keyCargo) {
		this.KeyCargo = keyCargo;
	}
}
