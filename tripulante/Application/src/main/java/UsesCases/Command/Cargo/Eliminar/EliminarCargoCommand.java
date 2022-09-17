package UsesCases.Command.Cargo.Eliminar;

import java.util.UUID;

import Dto.Cargo.CargoDto;
import Dto.Tripulante.TripulanteDto;
import Model.Tripulante.Cargo;
import Fourteam.mediator.Request;

public class EliminarCargoCommand implements Request<CargoDto> {

    CargoDto cargo;
    public EliminarCargoCommand(UUID key) {
        this.cargo = new CargoDto();
        this.cargo.key = key;
    }

}
