package UsesCases.Queries.Tripulante.GetAll;

import java.util.List;
import Model.Tripulante.Tripulante;
import Repositories.ITripulanteRepository;
import Fourteam.mediator.RequestHandler;

public class GetAllTripulanteHandler implements RequestHandler<GetAllTripulanteQuery, List<Tripulante>> {

    private ITripulanteRepository _tripulanteRepository;

    public GetAllTripulanteHandler(ITripulanteRepository tripulanteRepository) {
        this._tripulanteRepository = tripulanteRepository;
    }

    @Override
    public List<Tripulante> handle(GetAllTripulanteQuery request) throws Exception {
        return _tripulanteRepository.GetAll();
    }
}
