package UsesCases.Command.Tripulacion.DeleteTripulante;

import Factories.ITripulacionFactory;
import Factories.ITripulanteFactory;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Tripulante;
import Repositories.ITripulacionRepository;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import java.util.UUID;

public class DeleteTripulanteHandler
	implements RequestHandler<DeleteTripulanteCommand, UUID> {

	private ITripulacionFactory _tripulacionFactory;
	private ITripulacionRepository _tripulacionRepository;

	private ITripulanteFactory _tripulanteFactory;
	private ITripulanteRepository _tripulanteRepository;

	private IUnitOfWork _unitOfWork;

	public DeleteTripulanteHandler(
		ITripulacionFactory tripulacionFactory,
		ITripulacionRepository tripulacionRepository,
		ITripulanteFactory tripulanteFactory,
		ITripulanteRepository tripulanteRepository,
		IUnitOfWork _unitOfWork
	) {
		this._tripulacionFactory = tripulacionFactory;
		this._tripulacionRepository = tripulacionRepository;

		this._tripulanteFactory = tripulanteFactory;
		this._tripulanteRepository = tripulanteRepository;

		this._unitOfWork = _unitOfWork;
	}

	@Override
	public UUID handle(DeleteTripulanteCommand request) throws Exception {
		Tripulacion tripulacion = _tripulacionRepository.FindByKey(request.key);
		if (tripulacion == null) {
			throw new HttpException(
				HttpStatus.BAD_REQUEST,
				"Tripulacion no encontrado"
			);
		}

		Tripulante tripulante = _tripulanteRepository.FindByKey(
			request.Tripulante.key
		);
		if (tripulante == null) {
			throw new HttpException(
				HttpStatus.BAD_REQUEST,
				"Tripulante no encontrado"
			);
		}

		// Tripulacion tripulanteValidar = _tripulacionRepository.FindByTripulante(tripulacion, request.Tripulante.key);
		// if (tripulanteValidar != null) {
		// 	throw new HttpException(
		// 			HttpStatus.BAD_REQUEST,
		// 			"Tripulante ya existe");
		// }

		tripulacion.eliminarTripulante(request.Tripulante.key);
		//Change estado tripulante
		tripulante.setEstado(1);
		_tripulanteRepository.Update(tripulante);

		_tripulacionRepository.Update(tripulacion);
		_unitOfWork.commit();

		return tripulacion.getKey();
	}
}
