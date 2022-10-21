package UsesCases.Queries.Tripulacion.GetByKey;

import Dto.Tripulacion.TripulacionDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class GetTripulacionByKeyQuery implements Request<TripulacionDto> {

	// public GetTripulanteByKeyQuery() {
	//     System.out.println("Hola?");
	// }

	public GetTripulacionByKeyQuery(UUID key) {
		this.key = key;
	}

	public UUID key;
}
