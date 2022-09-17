package Factories;

import Model.Tripulante.Tripulante;

import java.util.List;

import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;

public interface ITripulacionFactory {


    // public Tripulacion Create( String descripcion, List<Tripulante> tripulantesList);
    public Tripulacion Create( String descripcion);
}
