package UsesCases.Command.Tripulante.Editar;

import Dto.Tripulante.TripulanteDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class EditarTripulanteCommand implements Request<TripulanteDto> {

	public TripulanteDto tripulanteDto;

	public EditarTripulanteCommand(UUID key) {
		this.tripulanteDto = new TripulanteDto();
		this.tripulanteDto.setKey(key);
	}
	// public EditarTripulanteCommand(TripulanteDto _tripulanteDto) {
	//     this.tripulanteDto = _tripulanteDto;
	// }

}
