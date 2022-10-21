package UsesCases.Command.Tripulante.Editar;

import Dto.Tripulante.TripulanteDto;
import Factories.ITripulanteFactory;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;
import Model.Tripulante.Tripulante;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;

public class EditarTripulanteHandler
	implements RequestHandler<EditarTripulanteCommand, TripulanteDto> {

	private ITripulanteFactory _tripulanteFactory;
	private ITripulanteRepository _tripulanteRepository;
	private IUnitOfWork _unitOfWork;

	public EditarTripulanteHandler(
		ITripulanteFactory tripulanteFactory,
		ITripulanteRepository tripulanteRepository,
		IUnitOfWork _unitOfWork
	) {
		this._tripulanteFactory = tripulanteFactory;
		this._tripulanteRepository = tripulanteRepository;
		this._unitOfWork = _unitOfWork;
	}

	@Override
	public TripulanteDto handle(EditarTripulanteCommand request)
		throws Exception {
		Tripulante tripulante = _tripulanteRepository.FindByKey(
			request.tripulanteDto.key
		);
		if (tripulante == null) {
			throw new HttpException(
				HttpStatus.BAD_REQUEST,
				"Tripulante no encontrado"
			);
		}
		tripulante.setNombre(request.tripulanteDto.Nombre);
		tripulante.setApellido(request.tripulanteDto.Apellido);
		tripulante.setEmailAddress(request.tripulanteDto.EmailAddress);
		// tripulante.setEstado(request.tripulanteDto.Estado);
		tripulante.setTipo(request.tripulanteDto.Tipo);
		tripulante.setHorasVuelo(request.tripulanteDto.HorasVuelo);
		tripulante.setNroMillas(request.tripulanteDto.NroMillas);
		tripulante.setKeyCargo(request.tripulanteDto.KeyCargo);
		_tripulanteRepository.Update(tripulante);
		// return tripulante;
		return new TripulanteDto(
			tripulante.key,
			tripulante.getNombre(),
			tripulante.getApellido(),
			tripulante.getEmailAddress(),
			tripulante.getTipo(),
			tripulante.getHorasVuelo(),
			tripulante.getNroMillas(),
			tripulante.getKeyCargo()
		);
	}
}
