package UsesCases.Queries.Tripulacion.GetByKey;

import Dto.Cargo.CargoDto;
import Dto.Tripulacion.TripulacionDto;
import Dto.Tripulante.TripulanteDto;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.HttpStatus;
import Fourteam.mediator.RequestHandler;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import Repositories.ICargoRepository;
import Repositories.ITripulacionRepository;
import Repositories.ITripulanteRepository;

public class GetTripulacionByKeyHandler
	implements RequestHandler<GetTripulacionByKeyQuery, TripulacionDto> {

	private ITripulacionRepository _tripulacionRepository;

	public GetTripulacionByKeyHandler(
		ITripulacionRepository tripulacionRepository
	) {
		this._tripulacionRepository = tripulacionRepository;
	}

	@Override
	public TripulacionDto handle(GetTripulacionByKeyQuery request)
		throws Exception {
		Tripulacion tripulacion = _tripulacionRepository.FindByKey(request.key);
		if (tripulacion == null) {
			throw new HttpException(
				HttpStatus.BAD_REQUEST,
				"Tripulacion no encontradooo"
			);
		}
		TripulacionDto tripulacionDto = new TripulacionDto();
		tripulacionDto.key = tripulacion.getKey();
		tripulacionDto.Descripcion = tripulacion.getDescripcion();
		return tripulacionDto;
	}
}
