package UsesCases.Queries.Tripulante.GetByKey;

import Dto.Tripulante.TripulanteDto;
// import Application.Dto.AsientoDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class GetTripulanteByKeyQuery implements Request<TripulanteDto> {

	// public GetTripulanteByKeyQuery() {
	//     System.out.println("Hola?");
	// }

	public GetTripulanteByKeyQuery(UUID key) {
		this.key = key;
	}

	public UUID key;
}
