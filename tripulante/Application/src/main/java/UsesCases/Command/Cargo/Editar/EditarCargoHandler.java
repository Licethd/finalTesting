package UsesCases.Command.Cargo.Editar;

import Dto.Cargo.CargoDto;
import Factories.ICargoFactory;
import Factories.ITripulanteFactory;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import Repositories.ICargoRepository;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;

public class EditarCargoHandler
	implements RequestHandler<EditarCargoCommand, CargoDto> {

	private ICargoFactory _cargoFactory;
	private ICargoRepository _cargoRepository;
	private IUnitOfWork _unitOfWork;

	public EditarCargoHandler(
		ICargoFactory cargoFactory,
		ICargoRepository cargoRepository,
		IUnitOfWork _unitOfWork
	) {
		this._cargoFactory = cargoFactory;
		this._cargoRepository = cargoRepository;
		this._unitOfWork = _unitOfWork;
	}

	@Override
	public CargoDto handle(EditarCargoCommand request) throws Exception {
		Cargo cargo = _cargoRepository.FindByKey(request.cargoDto.key);
		if (cargo == null) {
			throw new HttpException(
				HttpStatus.BAD_REQUEST,
				"Cargo no encontrado"
			);
		}
		// cargo.setSueldo(request.cargoDto.Sueldo);
		cargo.setDescripcion(request.cargoDto.Descripcion);
		_cargoRepository.Update(cargo);
		//return cargo;
		return new CargoDto(cargo.key, cargo.getDescripcion());
	}
}
