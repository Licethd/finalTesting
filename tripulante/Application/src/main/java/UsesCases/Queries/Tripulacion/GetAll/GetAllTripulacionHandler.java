package UsesCases.Queries.Tripulacion.GetAll;

import Fourteam.mediator.RequestHandler;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import Repositories.ITripulacionRepository;
import java.util.List;

public class GetAllTripulacionHandler
	implements RequestHandler<GetAllTripulacionQuery, List<Tripulacion>> {

	private ITripulacionRepository _tripulacionRepository;

	public GetAllTripulacionHandler(
		ITripulacionRepository tripulacionRepository
	) {
		this._tripulacionRepository = tripulacionRepository;
	}

	@Override
	public List<Tripulacion> handle(GetAllTripulacionQuery request)
		throws Exception {
		return _tripulacionRepository.GetAll();
	}
}
