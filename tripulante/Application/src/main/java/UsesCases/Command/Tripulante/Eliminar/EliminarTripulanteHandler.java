package UsesCases.Command.Tripulante.Eliminar;

import java.util.UUID;

import Factories.ITripulanteFactory;
import Model.Tripulante.Tripulante;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;

public class EliminarTripulanteHandler implements RequestHandler<EliminarTripulanteCommand, UUID> {

    private ITripulanteFactory _tripulanteFactory;
    private ITripulanteRepository _tripulanteRepository;
    private IUnitOfWork _unitOfWork;

    public EliminarTripulanteHandler(ITripulanteFactory tripulanteFactory, ITripulanteRepository tripulanteRepository,
            IUnitOfWork _unitOfWork) {
        this._tripulanteFactory = tripulanteFactory;
        this._tripulanteRepository = tripulanteRepository;
        this._unitOfWork = _unitOfWork;
    }

    @Override
    public UUID handle(EliminarTripulanteCommand request) throws Exception {
        Tripulante tripulante = _tripulanteRepository.FindByKey(request.tripulante.key);
        if (tripulante == null) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Tripulante no encontrado");
        }

        return _tripulanteRepository.Delete(tripulante).key;

    }

}
