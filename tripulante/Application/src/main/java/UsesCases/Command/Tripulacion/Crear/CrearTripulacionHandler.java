package UsesCases.Command.Tripulacion.Crear;

import Factories.ICargoFactory;
import Factories.ITripulacionFactory;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import Repositories.ITripulacionRepository;
import Repositories.IUnitOfWork;
import java.util.UUID;

public class CrearTripulacionHandler
	implements RequestHandler<CrearTripulacionCommand, UUID> {

	private ITripulacionFactory _tripulacionFactory;
	private ITripulacionRepository _tripulacionRepository;
	private IUnitOfWork _unitOfWork;

	public CrearTripulacionHandler(
		ITripulacionFactory tripulacionFactory,
		ITripulacionRepository tripulacionRepository,
		IUnitOfWork _unitOfWork
	) {
		this._tripulacionFactory = tripulacionFactory;
		this._tripulacionRepository = tripulacionRepository;
		this._unitOfWork = _unitOfWork;
	}

	@Override
	public UUID handle(CrearTripulacionCommand request) throws Exception {
		Tripulacion tripulacion = _tripulacionFactory.Create(
			request.tripulacionDto.Descripcion
		);

		tripulacion.eventCreado();

		_tripulacionRepository.Create(tripulacion);
		_unitOfWork.commit();
		return tripulacion.key;
	}
}
