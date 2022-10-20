package UsesCases.Command.Tripulante.Crear;

import Dto.Tripulante.TripulanteDto;
import Fourteam.mediator.Request;

public class CrearTripulanteCommand implements Request<TripulanteDto> {

	public TripulanteDto tripulanteDto;

	public CrearTripulanteCommand(TripulanteDto tripu) {
		tripulanteDto = tripu;
	}
}
