package UsesCases.Queries.Tripulante.GetByKey;

import Dto.Tripulante.TripulanteDto;
import Model.Tripulante.Tripulante;
import Repositories.ITripulanteRepository;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Fourteam.mediator.RequestHandler;

public class GetTripulanteByKeyHandler implements RequestHandler<GetTripulanteByKeyQuery, TripulanteDto> {

    private ITripulanteRepository _tripulanteRepository;
    public GetTripulanteByKeyHandler(ITripulanteRepository tripulanteRepository) {
        this._tripulanteRepository = tripulanteRepository;
    }

    @Override
    public TripulanteDto handle(GetTripulanteByKeyQuery request) throws Exception {
        Tripulante tripulante = _tripulanteRepository.FindByKey(request.key);
        if (tripulante == null) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Tripulante no encontradooo");
        }
        TripulanteDto tripulanteDto =  new TripulanteDto();
        tripulanteDto.Key = tripulante.key;
        tripulanteDto.Nombre = tripulante.getNombre();
        tripulanteDto.Apellido = tripulante.getApellido();
        tripulanteDto.EmailAddress = tripulante.getEmailAddress();
        // tripulanteDto.Estado = tripulante.getEstado();
        tripulanteDto.Tipo = tripulante.getTipo();
        tripulanteDto.HorasVuelo = tripulante.getHorasVuelo();
        tripulanteDto.NroMillas = tripulante.getNroMillas();
        tripulanteDto.Cargo = tripulante.getCargo();

        return tripulanteDto;
    }
}
