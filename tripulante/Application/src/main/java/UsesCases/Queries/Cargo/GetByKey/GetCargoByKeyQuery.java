package UsesCases.Queries.Cargo.GetByKey;

import Dto.Cargo.CargoDto;
import Dto.Tripulante.TripulanteDto;
// import Application.Dto.AsientoDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class GetCargoByKeyQuery implements Request<CargoDto> {

	// public GetTripulanteByKeyQuery() {
	//     System.out.println("Hola?");
	// }

	public GetCargoByKeyQuery(UUID key) {
		this.key = key;
	}

	public UUID key;
}
