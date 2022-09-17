package UsesCases.Queries.Tripulacion.GetAll;

import java.util.List;

import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import Repositories.ITripulacionRepository;
import Fourteam.mediator.RequestHandler;

public class GetAllTripulacionHandler implements RequestHandler<GetAllTripulacionQuery, List<Tripulacion>> {

    private ITripulacionRepository _tripulacionRepository;

    public GetAllTripulacionHandler(ITripulacionRepository tripulacionRepository) {
        this._tripulacionRepository = tripulacionRepository;
    }

    @Override
    public List<Tripulacion> handle(GetAllTripulacionQuery request) throws Exception {
        return _tripulacionRepository.GetAll();
    }
}
