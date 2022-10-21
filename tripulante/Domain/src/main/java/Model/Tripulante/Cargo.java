package Model.Tripulante;

import core.Entity;
import java.util.UUID;

// import java.util.Date;

public class Cargo extends Entity<UUID> {

	// public abstract class Cargo extends Tripulante {
	// private UUID key;
	private String Descripcion;
	private Double sueldo;

	// private Date fecha_ingreso;

	public Cargo() {}

	public Cargo(String descripcion) {
		key = UUID.randomUUID();
		this.Descripcion = descripcion;
		// this.sueldo = sueldo;
	}

	public UUID getKeyCargo() {
		return key;
	}

	public void setKeyCargo(UUID key) {
		this.key = key;
	}

	// public Double getSueldo() {
	// 	return sueldo;
	// }

	// public void setSueldo(Double sueldo) {
	// 	this.sueldo = sueldo;
	// }

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.Descripcion = descripcion;
	}
	// @Override
	// public String toString() {
	// return "Cargo{" + "descripcion=" + descripcion + ", sueldo=" + sueldo + '}';
	// }

	// CAMBIOS
	// public Cargo(String descripcion) {
	// key = UUID.randomUUID();
	// this.descripcion = descripcion;
	// }

}
