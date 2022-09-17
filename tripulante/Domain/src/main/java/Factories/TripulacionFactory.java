package Factories;

import java.util.List;

import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;

public class TripulacionFactory implements ITripulacionFactory {

	public TripulacionFactory() {

	}

	@Override
	// public Tripulacion Create(String descripcion, List<Tripulante> tripulantesList) {

	// 	return new Tripulacion(descripcion, tripulantesList);
	// }

	public Tripulacion Create(String descripcion) {


		return new Tripulacion(descripcion);
	}

}
