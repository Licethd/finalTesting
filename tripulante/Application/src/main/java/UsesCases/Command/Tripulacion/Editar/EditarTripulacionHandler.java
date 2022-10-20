package UsesCases.Command.Tripulacion.Editar;

import Dto.Tripulacion.TripulacionDto;
import Factories.ICargoFactory;
import Factories.ITripulacionFactory;
import Factories.ITripulanteFactory;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import Repositories.ICargoRepository;
import Repositories.ITripulacionRepository;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;

public class EditarTripulacionHandler
	implements RequestHandler<EditarTripulacionCommand, TripulacionDto> {

	private ITripulacionFactory _tripulacionFactory;
	private ITripulacionRepository _tripulacionRepository;
	private IUnitOfWork _unitOfWork;

	public EditarTripulacionHandler(
		ITripulacionFactory tripulacionFactory,
		ITripulacionRepository tripulacionRepository,
		IUnitOfWork _unitOfWork
	) {
		this._tripulacionFactory = tripulacionFactory;
		this._tripulacionRepository = tripulacionRepository;
		this._unitOfWork = _unitOfWork;
	}

	@Override
	public TripulacionDto handle(EditarTripulacionCommand request)
		throws Exception {
		Tripulacion tripulacion = _tripulacionRepository.FindByKey(
			request.tripulacionDto.key
		);
		if (tripulacion == null) {
			throw new HttpException(
				HttpStatus.BAD_REQUEST,
				"Cargo no encontrado"
			);
		}
		// cargo.setSueldo(request.cargoDto.Sueldo);
		tripulacion.setDescripcion(request.tripulacionDto.Descripcion);
		//tripulacion.setEstado(Integer.parseInt(request.tripulacionDto.Estado));

		_tripulacionRepository.Update(tripulacion);
		//return tripulacion;
		return new TripulacionDto(
			tripulacion.key,
			tripulacion.getDescripcion()
		);
	}
}
