package Factories;

import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import java.util.List;

public interface ITripulacionFactory {
	// public Tripulacion Create( String descripcion, List<Tripulante> tripulantesList);
	public Tripulacion Create(String descripcion);
}
