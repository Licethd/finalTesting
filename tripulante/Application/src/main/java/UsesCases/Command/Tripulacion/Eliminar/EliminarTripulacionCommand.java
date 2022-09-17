package UsesCases.Command.Tripulacion.Eliminar;

import java.util.UUID;

import Dto.Cargo.CargoDto;
import Dto.Tripulacion.TripulacionDto;
import Dto.Tripulante.TripulanteDto;
import Model.Tripulante.Cargo;
import Fourteam.mediator.Request;

public class EliminarTripulacionCommand implements Request<TripulacionDto> {

    TripulacionDto tripulacion;
    public EliminarTripulacionCommand(UUID key) {
        this.tripulacion = new TripulacionDto();
        this.tripulacion.key = key;
    }

}
