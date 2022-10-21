package Factories;

import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;

public interface ICargoFactory {
	public Cargo Create(String descripcion);
}
