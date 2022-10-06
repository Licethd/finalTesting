package Factories;

// import Domain.Factories.TripulanteFactory.Cargo;
import Model.Tripulante.Tripulante;

import java.util.UUID;

import Model.Tripulante.Cargo;

public interface ITripulanteFactory {


    public Tripulante Create(String nombre, String apellido, String emailAddress,String estado, String tipo,Double horasVuelo,Double nroMillas, UUID keyCargo);
}
