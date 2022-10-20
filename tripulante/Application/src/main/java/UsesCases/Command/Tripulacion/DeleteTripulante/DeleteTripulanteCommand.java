package UsesCases.Command.Tripulacion.DeleteTripulante;

import Dto.Tripulante.TripulanteDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class DeleteTripulanteCommand implements Request<TripulanteDto> {

	public UUID key;
	public TripulanteDto Tripulante;

	public DeleteTripulanteCommand(UUID key) {
		this.key = key;
	}

	public void setTripulante(TripulanteDto tripulante) {
		this.Tripulante = tripulante;
	}
	// public EditarTripulanteCommand(TripulanteDto _tripulanteDto) {
	//     this.tripulanteDto = _tripulanteDto;
	// }

}
