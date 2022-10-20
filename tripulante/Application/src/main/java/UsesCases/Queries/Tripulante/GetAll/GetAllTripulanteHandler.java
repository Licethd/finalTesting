package UsesCases.Queries.Tripulante.GetAll;

import Dto.Tripulante.TripulanteDto;
import Fourteam.mediator.RequestHandler;
import Model.Tripulante.Tripulante;
import Repositories.ITripulanteRepository;
import java.util.ArrayList;
import java.util.List;

public class GetAllTripulanteHandler
	implements RequestHandler<GetAllTripulanteQuery, List<TripulanteDto>> {

	private ITripulanteRepository _tripulanteRepository;

	public GetAllTripulanteHandler(ITripulanteRepository tripulanteRepository) {
		this._tripulanteRepository = tripulanteRepository;
	}

	@Override
	public List<TripulanteDto> handle(GetAllTripulanteQuery request)
		throws Exception {
		List<Tripulante> lista = _tripulanteRepository.GetAll();
		List<TripulanteDto> resp = new ArrayList<>();
		for (Tripulante tripulante : lista) {
			TripulanteDto tripulante_dto = new TripulanteDto();
			tripulante_dto.setKey(tripulante.getKey());
			tripulante_dto.setNombre(tripulante.getNombre());
			tripulante_dto.setApellido(tripulante.getApellido());
			tripulante_dto.setEmailAddress(tripulante.getEmailAddress());
			tripulante_dto.setEstado(tripulante.getEstado() + "");
			tripulante_dto.setTipo(tripulante.getTipo());
			tripulante_dto.setHorasVuelo(tripulante.getHorasVuelo());
			tripulante_dto.setNroMillas(tripulante.getNroMillas());
			tripulante_dto.setKeyCargo(tripulante.getKeyCargo());
			resp.add(tripulante_dto);
		}
		return resp;
		// return _tripulanteRepository.GetAll();
	}
}
