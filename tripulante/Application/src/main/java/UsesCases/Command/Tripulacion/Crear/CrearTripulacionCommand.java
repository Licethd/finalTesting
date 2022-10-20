package UsesCases.Command.Tripulacion.Crear;

import Dto.Cargo.CargoDto;
import Dto.Tripulacion.TripulacionDto;
import Fourteam.mediator.Request;

public class CrearTripulacionCommand implements Request<TripulacionDto> {

	public TripulacionDto tripulacionDto;

	public CrearTripulacionCommand(TripulacionDto tripulacion) {
		tripulacionDto = tripulacion;
	}
}
