package Factories;

import Model.Tripulante.Cargo;

public class CargoFactory implements ICargoFactory {

	public CargoFactory() {}

	@Override
	public Cargo Create(String descripcion) {
		return new Cargo(descripcion);
	}
}
