package UsesCases.Command.Tripulacion.Eliminar;

import Factories.ICargoFactory;
import Factories.ITripulacionFactory;
import Factories.ITripulanteFactory;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import Repositories.ICargoRepository;
import Repositories.ITripulacionRepository;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;

public class EliminarTripulacionHandler implements RequestHandler<EliminarTripulacionCommand, Tripulacion> {

    private ITripulacionFactory _tripulacionFactory;
    private ITripulacionRepository _tripulacionRepository;
    private IUnitOfWork _unitOfWork;

    public EliminarTripulacionHandler(ITripulacionFactory tripulacionFactory, ITripulacionRepository tripulacionRepository,
            IUnitOfWork _unitOfWork) {
        this._tripulacionFactory = tripulacionFactory;
        this._tripulacionRepository = tripulacionRepository;
        this._unitOfWork = _unitOfWork;
    }

    @Override
    public Tripulacion handle(EliminarTripulacionCommand request) throws Exception {
        Tripulacion tripulacion = _tripulacionRepository.FindByKey(request.tripulacion.key);
        if (tripulacion == null) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Cargo no encontrado");
        }

        return _tripulacionRepository.Delete(tripulacion);

    }

}
