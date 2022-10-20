package Controllers;

import Dto.Tripulante.TripulanteDto;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.annotation.*;
import Fourteam.mediator.Mediator;
import Fourteam.mediator.Response;
import Model.Tripulante.*;
import UsesCases.Command.Tripulante.Crear.CrearTripulanteCommand;
import UsesCases.Command.Tripulante.Editar.EditarTripulanteCommand;
import UsesCases.Command.Tripulante.Eliminar.EliminarTripulanteCommand;
import UsesCases.Queries.Tripulante.GetAll.GetAllTripulanteQuery;
import UsesCases.Queries.Tripulante.GetByKey.GetTripulanteByKeyQuery;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tripulante")
public class TripulanteController {

	private Mediator _mediator;

	public TripulanteController(Mediator mediator) {
		this._mediator = mediator;
	}

	@GetMapping("/")
	public List<TripulanteDto> getAll() throws Exception {
		Response<List<TripulanteDto>> lista = _mediator.send(
			new GetAllTripulanteQuery()
		);
		return lista.data;
		// try {
		// Response<List<TripulanteDto>> lista = _mediator.send(new
		// GetAllTripulanteQuery());
		// return lista.data;
		// } catch (Exception e) {
		// throw (HttpException) e.getCause();
		// }
	}

	@GetMapping("/{key}")
	// public Response<TripulanteDto> getByKey(@PathVariable GetTripulanteByKeyQuery
	// request)
	public TripulanteDto getByKey(
		@PathVariable GetTripulanteByKeyQuery request
	) throws Exception {
		return (TripulanteDto) _mediator.send(request).data;
	}

	@PostMapping("/registro")
	public UUID register(@RequestBody CrearTripulanteCommand tripulante)
		throws Exception {
		return (UUID) _mediator.send(tripulante).data;
		// return _mediator.send(tripulacion);
	}

	@PutMapping("/{key}")
	public TripulanteDto edit(
		@RequestBody Tripulante tripulante,
		@PathVariable EditarTripulanteCommand request
	) throws Exception {
		request.tripulanteDto.Nombre = tripulante.getNombre();
		request.tripulanteDto.Apellido = tripulante.getApellido();
		request.tripulanteDto.EmailAddress = tripulante.getEmailAddress();
		request.tripulanteDto.Estado = tripulante.getEstado() + "";
		request.tripulanteDto.Tipo = tripulante.getTipo();
		request.tripulanteDto.HorasVuelo = tripulante.getHorasVuelo();
		request.tripulanteDto.NroMillas = tripulante.getNroMillas();
		request.tripulanteDto.KeyCargo = tripulante.getKeyCargo();

		return (TripulanteDto) _mediator.send(request).data;
		// try {
		// return (TripulanteDto) _mediator.send(request).data;
		// } catch (Exception e) {
		// throw (HttpException) e.getCause();
		// }
	}

	@DeleteMapping("/{key}")
	public UUID delete(@PathVariable EliminarTripulanteCommand request)
		throws Exception {
		return (UUID) _mediator.send(request).data;
		// try {
		// return (UUID) _mediator.send(request).data;
		// } catch (Exception e) {
		// throw (HttpException) e.getCause();
		// }
	}
}
