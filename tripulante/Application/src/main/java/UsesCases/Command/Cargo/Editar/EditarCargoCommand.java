package UsesCases.Command.Cargo.Editar;

import Dto.Cargo.CargoDto;
import Fourteam.mediator.Request;
import java.util.UUID;

public class EditarCargoCommand implements Request<CargoDto> {

	public CargoDto cargoDto;

	public EditarCargoCommand(UUID key) {
		this.cargoDto = new CargoDto();
		this.cargoDto.setKey(key);
	}
	// public EditarTripulanteCommand(TripulanteDto _tripulanteDto) {
	//     this.tripulanteDto = _tripulanteDto;
	// }

}
