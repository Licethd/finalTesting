package Factories;

import Model.Tripulante.Tripulante;
import Model.Tripulante.Cargo;

public interface ICargoFactory {


    public Cargo Create( String descripcion);
}
