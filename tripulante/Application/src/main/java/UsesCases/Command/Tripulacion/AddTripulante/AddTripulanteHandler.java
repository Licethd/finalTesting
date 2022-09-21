package UsesCases.Command.Tripulacion.AddTripulante;

import java.util.UUID;

import Factories.ITripulacionFactory;
import Factories.ITripulanteFactory;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Tripulante;
import Repositories.ITripulacionRepository;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;

public class AddTripulanteHandler
		implements RequestHandler<AddTripulanteCommand, UUID> {

	private ITripulacionFactory _tripulacionFactory;
	private ITripulacionRepository _tripulacionRepository;

	private ITripulanteFactory _tripulanteFactory;
	private ITripulanteRepository _tripulanteRepository;

	private IUnitOfWork _unitOfWork;

	public AddTripulanteHandler(
			ITripulacionFactory tripulacionFactory,
			ITripulacionRepository tripulacionRepository,
			ITripulanteFactory tripulanteFactory,
			ITripulanteRepository tripulanteRepository,
			IUnitOfWork _unitOfWork) {
		this._tripulacionFactory = tripulacionFactory;
		this._tripulacionRepository = tripulacionRepository;

		this._tripulanteFactory = tripulanteFactory;
		this._tripulanteRepository = tripulanteRepository;

		this._unitOfWork = _unitOfWork;
	}

	@Override
	public UUID handle(AddTripulanteCommand request)
			throws Exception {
		Tripulacion tripulacion = _tripulacionRepository.FindByKey(
				request.key);
		if (tripulacion == null) {
			throw new HttpException(
					HttpStatus.BAD_REQUEST,
					"Tripulacion no encontrado");
		}

		Tripulante tripulante = _tripulanteRepository.FindByKey(request.Tripulante.Key);
		if (tripulante == null) {
			throw new HttpException(
					HttpStatus.BAD_REQUEST,
					"Tripulante no encontrado");
		}




		tripulacion.agregarTripulante(tripulante);
		_tripulacionRepository.Update(tripulacion);
		_unitOfWork.commit();

		return tripulante.getKey();

	}
}
