package UsesCases.Command.Cargo.Crear;

import Factories.ICargoFactory;
import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import Repositories.IUnitOfWork;
import Fourteam.mediator.RequestHandler;

public class CrearCargoHandler implements RequestHandler<CrearCargoCommand, Cargo> {

    private ICargoFactory _cargoFactory;
    private ICargoRepository _cargoRepository;
    private IUnitOfWork _unitOfWork;

    public CrearCargoHandler( ICargoFactory cargoFactory, ICargoRepository cargoRepository, IUnitOfWork _unitOfWork ) {
       this._cargoFactory = cargoFactory;
       this._cargoRepository = cargoRepository;
       this._unitOfWork = _unitOfWork;
    }

    @Override
    public Cargo handle(CrearCargoCommand request) throws Exception {

        // Tripulante tripulante = _tripulanteFactory.Create(request.tripulanteDto.getNombre(), request.tripulanteDto.getApellido(), request.tripulanteDto.getEmailAddress(), request.tripulanteDto.getCargo());
        Cargo cargo = _cargoFactory.Create( request.cargoDto.Descripcion);

        // cargo.eventCreado();

        _cargoRepository.Create(cargo);
        _unitOfWork.commit();
        return cargo;
    }

}
