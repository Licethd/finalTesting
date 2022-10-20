package UsesCases.Command.Tripulante.Crear;

import Factories.ITripulanteFactory;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import Repositories.ICargoRepository;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import java.util.UUID;

public class CrearTripulanteHandler
	implements RequestHandler<CrearTripulanteCommand, UUID> {

	private ITripulanteFactory _tripulanteFactory;
	private ITripulanteRepository _tripulanteRepository;

	private ICargoRepository _cargoRepository;

	private IUnitOfWork _unitOfWork;

	public CrearTripulanteHandler(
		ITripulanteFactory tripulanteFactory,
		ITripulanteRepository tripulanteRepository,
		ICargoRepository cargoRepository,
		IUnitOfWork _unitOfWork
	) {
		this._tripulanteFactory = tripulanteFactory;
		this._tripulanteRepository = tripulanteRepository;
		this._cargoRepository = cargoRepository;

		this._unitOfWork = _unitOfWork;
	}

	@Override
	public UUID handle(CrearTripulanteCommand request) throws Exception {
		// Tripulante tripulante =
		// _tripulanteFactory.Create(request.tripulanteDto.getNombre(),
		// request.tripulanteDto.getApellido(), request.tripulanteDto.getEmailAddress(),
		// request.tripulanteDto.getCargo());

		Cargo cargo = _cargoRepository.FindByKey(
			request.tripulanteDto.KeyCargo
		);
		if (cargo == null) {
			throw new HttpException(
				HttpStatus.BAD_REQUEST,
				"Cargo no encontrado"
			);
		}

		Tripulante tripulante = _tripulanteFactory.Create(
			request.tripulanteDto.Nombre,
			request.tripulanteDto.Apellido,
			request.tripulanteDto.EmailAddress,
			request.tripulanteDto.Estado,
			request.tripulanteDto.Tipo,
			request.tripulanteDto.HorasVuelo,
			request.tripulanteDto.NroMillas,
			cargo.key
		);

		tripulante.eventCreado();

		_tripulanteRepository.Create(tripulante);
		_unitOfWork.commit();
		return tripulante.key;
	}
}
