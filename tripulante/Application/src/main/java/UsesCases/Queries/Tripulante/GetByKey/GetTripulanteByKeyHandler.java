package UsesCases.Queries.Tripulante.GetByKey;

import Dto.Tripulante.TripulanteDto;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;
import Model.Tripulante.Tripulante;
import Repositories.ITripulanteRepository;

public class GetTripulanteByKeyHandler
	implements RequestHandler<GetTripulanteByKeyQuery, TripulanteDto> {

	private ITripulanteRepository _tripulanteRepository;

	public GetTripulanteByKeyHandler(
		ITripulanteRepository tripulanteRepository
	) {
		this._tripulanteRepository = tripulanteRepository;
	}

	@Override
	public TripulanteDto handle(GetTripulanteByKeyQuery request)
		throws Exception {
		Tripulante tripulante = _tripulanteRepository.FindByKey(request.key);
		if (tripulante == null) {
			throw new HttpException(
				HttpStatus.BAD_REQUEST,
				"Tripulante no encontradooo"
			);
		}
		TripulanteDto tripulanteDto = new TripulanteDto();
		tripulanteDto.key = tripulante.key;
		tripulanteDto.Nombre = tripulante.getNombre();
		tripulanteDto.Apellido = tripulante.getApellido();
		tripulanteDto.EmailAddress = tripulante.getEmailAddress();
		// tripulanteDto.Estado = tripulante.getEstado();
		tripulanteDto.Tipo = tripulante.getTipo();
		tripulanteDto.HorasVuelo = tripulante.getHorasVuelo();
		tripulanteDto.NroMillas = tripulante.getNroMillas();
		tripulanteDto.KeyCargo = tripulante.getKeyCargo();

		return tripulanteDto;
	}
}
