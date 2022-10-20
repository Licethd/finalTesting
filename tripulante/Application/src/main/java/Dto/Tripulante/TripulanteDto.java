package Dto.Tripulante;

import Model.Tripulante.Cargo;
import java.util.UUID;

public class TripulanteDto {

	public UUID key;
	public String Nombre;
	public String Apellido;
	public String EmailAddress;
	public String Estado;
	public String Tipo;
	public Double HorasVuelo;

	public Double NroMillas;
	public UUID KeyCargo;

	public TripulanteDto() {}

	public TripulanteDto(
		UUID key,
		String nombre,
		String apellido,
		String emailAddress,
		String tipo,
		Double horasVuelo,
		Double nroMillas,
		UUID keyCargo
	) {
		this.key = key;
		Nombre = nombre;
		Apellido = apellido;
		EmailAddress = emailAddress;
		Estado = "1";
		Tipo = tipo;
		HorasVuelo = horasVuelo;
		NroMillas = nroMillas;
		KeyCargo = keyCargo;
	}

	public void setKey(UUID key) {
		this.key = key;
	}

	public UUID getKey() {
		return key;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public UUID getKeyCargo() {
		return KeyCargo;
	}

	public void setKeyCargo(UUID keyCargo) {
		KeyCargo = keyCargo;
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
}
