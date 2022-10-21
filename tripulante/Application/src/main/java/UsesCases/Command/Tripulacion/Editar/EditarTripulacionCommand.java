package UsesCases.Command.Tripulacion.Editar;

import Dto.Cargo.CargoDto;
import Dto.Tripulacion.TripulacionDto;
import Dto.Tripulante.TripulanteDto;
import Fourteam.mediator.Request;
import java.security.KeyException;
import java.util.UUID;

public class EditarTripulacionCommand implements Request<TripulacionDto> {

	public TripulacionDto tripulacionDto;

	public EditarTripulacionCommand(UUID key) {
		this.tripulacionDto = new TripulacionDto();
		this.tripulacionDto.setKey(key);
	}
	// public EditarTripulanteCommand(TripulanteDto _tripulanteDto) {
	//     this.tripulanteDto = _tripulanteDto;
	// }

}
