package UsesCases.Command.Tripulacion.Eliminar;

import Dto.Cargo.CargoDto;
import Dto.Tripulacion.TripulacionDto;
import Dto.Tripulante.TripulanteDto;
import Fourteam.mediator.Request;
import Model.Tripulante.Cargo;
import java.util.UUID;

public class EliminarTripulacionCommand implements Request<TripulacionDto> {

	TripulacionDto tripulacion;

	public EliminarTripulacionCommand(UUID key) {
		this.tripulacion = new TripulacionDto();
		this.tripulacion.key = key;
	}
}
