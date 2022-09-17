package UsesCases.Queries.Cargo.GetAll;

import java.util.List;

import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import Fourteam.mediator.RequestHandler;

public class GetAllCargoHandler implements RequestHandler<GetAllCargoQuery, List<Cargo>> {

    private ICargoRepository _cargoRepository;

    public GetAllCargoHandler(ICargoRepository cargoRepository) {
        this._cargoRepository = cargoRepository;
    }

    @Override
    public List<Cargo> handle(GetAllCargoQuery request) throws Exception{
        return _cargoRepository.GetAll();
    }
}
