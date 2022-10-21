package UsesCases.Command.Cargo.Crear;

import Dto.Cargo.CargoDto;
import Fourteam.mediator.Request;

public class CrearCargoCommand implements Request<CargoDto> {

	public CargoDto cargoDto;

	public CrearCargoCommand(CargoDto cargo) {
		cargoDto = cargo;
	}
}
