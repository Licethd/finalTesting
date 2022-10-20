package UsesCases.Command.Cargo.Eliminar;

import Factories.ICargoFactory;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;
import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import Repositories.IUnitOfWork;
import java.util.UUID;

public class EliminarCargoHandler
	implements RequestHandler<EliminarCargoCommand, UUID> {

	private ICargoFactory _cargoFactory;
	private ICargoRepository _cargoRepository;
	private IUnitOfWork _unitOfWork;

	public EliminarCargoHandler(
		ICargoFactory cargoFactory,
		ICargoRepository cargoRepository,
		IUnitOfWork _unitOfWork
	) {
		this._cargoFactory = cargoFactory;
		this._cargoRepository = cargoRepository;
		this._unitOfWork = _unitOfWork;
	}

	@Override
	public UUID handle(EliminarCargoCommand request) throws Exception {
		Cargo cargo = _cargoRepository.FindByKey(request.cargo.key);
		if (cargo == null) {
			throw new HttpException(
				HttpStatus.BAD_REQUEST,
				"Cargo no encontrado"
			);
		}

		return _cargoRepository.Delete(cargo).key;
	}
}
