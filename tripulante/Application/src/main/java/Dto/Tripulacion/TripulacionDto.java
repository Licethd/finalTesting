package Dto.Tripulacion;

import Dto.Tripulante.TripulanteDto;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TripulacionDto {

	public UUID key;
	// public Double Sueldo;
	public String Descripcion;
	public String Estado;
	public List<TripulanteDto> Tripulantes;

	public TripulacionDto() {}

	public TripulacionDto(UUID key, String descripcion) {
		this.key = key;
		// this.Sueldo = sueldo;
		this.Descripcion = descripcion;
		this.Estado = 1 + "";
		this.Tripulantes = new ArrayList<>();
	}

	public void setKey(UUID keyCargo) {
		this.key = keyCargo;
	}

	public UUID getKey() {
		return key;
	}

	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.Descripcion = descripcion;
	}

	public String getEstado() {
		return this.Estado;
	}

	public void setEstado(String estado) {
		this.Estado = estado;
	}

	public List<TripulanteDto> getTripulantes() {
		return this.Tripulantes;
	}

	public void setTripulantes(List<TripulanteDto> tripulantes) {
		this.Tripulantes = tripulantes;
	}
}
