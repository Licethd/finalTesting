package Event;

import core.DomainEvent;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import Model.Tripulante.Tripulante;


public class TripulacionChange extends DomainEvent {

	public UUID KeyTripulacion;
	public String Nombre;
	public List<Tripulante> Tripulantes;

	public TripulacionChange(UUID key, String nombre, List<Tripulante> Tripu) {
		// public TripulacionRegistrado(UUID key, String nombre) {
		super(LocalDateTime.now());
		KeyTripulacion = key;
		Nombre = nombre;
		Tripulantes = Tripu;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public List<Tripulante> getTripulantes() {
		return this.Tripulantes;
	}

	public void setTripulantes(List<Tripulante> tripulantes) {
		this.Tripulantes = tripulantes;
	}
}
