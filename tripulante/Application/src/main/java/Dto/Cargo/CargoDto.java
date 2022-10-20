package Dto.Cargo;

import java.util.UUID;

public class CargoDto {

	public UUID key;
	// public Double Sueldo;
	public String Descripcion;

	public CargoDto() {}

	public CargoDto(UUID key, String descripcion) {
		this.key = key;
		// this.Sueldo = sueldo;
		this.Descripcion = descripcion;
	}

	public void setKey(UUID keyCargo) {
		this.key = keyCargo;
	}

	public UUID getKey() {
		return key;
	}

	// public Double getSueldo() {
	// 	return this.Sueldo;
	// }

	// public void setSueldo(Double sueldo) {
	// 	this.Sueldo = sueldo;
	// }

	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.Descripcion = descripcion;
	}
}
