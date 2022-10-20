package UsesCases.Command.Cargo.Eliminar;

import Dto.Cargo.CargoDto;
import Dto.Tripulante.TripulanteDto;
import Fourteam.mediator.Request;
import Model.Tripulante.Cargo;
import java.util.UUID;

public class EliminarCargoCommand implements Request<CargoDto> {

	CargoDto cargo;

	public EliminarCargoCommand(UUID key) {
		this.cargo = new CargoDto();
		this.cargo.key = key;
	}
}
