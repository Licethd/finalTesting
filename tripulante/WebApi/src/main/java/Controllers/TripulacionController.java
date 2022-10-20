package Controllers;

import Dto.Tripulacion.TripulacionDto;
import Dto.Tripulante.TripulanteDto;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.annotation.*;
import Fourteam.mediator.Mediator;
import Fourteam.mediator.Response;
import Model.Tripulacion.Tripulacion;
import UsesCases.Command.Tripulacion.AddTripulante.AddTripulanteCommand;
import UsesCases.Command.Tripulacion.Crear.CrearTripulacionCommand;
import UsesCases.Command.Tripulacion.DeleteTripulante.DeleteTripulanteCommand;
import UsesCases.Command.Tripulacion.Editar.EditarTripulacionCommand;
import UsesCases.Command.Tripulacion.Eliminar.EliminarTripulacionCommand;
import UsesCases.Queries.Tripulacion.GetAll.GetAllTripulacionQuery;
import UsesCases.Queries.Tripulacion.GetByKey.GetTripulacionByKeyQuery;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tripulacion")
public class TripulacionController {

	private Mediator _mediator;

	public TripulacionController(Mediator mediator) {
		this._mediator = mediator;
	}

	@GetMapping("/")
	public List<TripulacionDto> getAll() throws Exception {
		Response<List<TripulacionDto>> lista = _mediator.send(
			new GetAllTripulacionQuery()
		);
		return lista.data;
	}

	@GetMapping("/{key}")
	public TripulacionDto getByKey(
		@PathVariable GetTripulacionByKeyQuery request
	) throws Exception {
		return (TripulacionDto) _mediator.send(request).data;
	}

	@PostMapping("/registro")
	public UUID register(@RequestBody CrearTripulacionCommand tripulacion)
		throws Exception {
		return (UUID) _mediator.send(tripulacion).data;
	}

	@PutMapping("/{key}")
	public TripulacionDto edit(
		@RequestBody Tripulacion tripulacion,
		@PathVariable EditarTripulacionCommand request
	) throws Exception {
		request.tripulacionDto.Descripcion = tripulacion.getDescripcion();
		return (TripulacionDto) _mediator.send(request).data;
	}

	@PutMapping("/addTripulante/{key}")
	public UUID addTripulante(
		@RequestBody TripulanteDto tripulanteDto,
		@PathVariable AddTripulanteCommand request
	) throws Exception {
		request.setTripulante(tripulanteDto);
		return (UUID) _mediator.send(request).data;
	}

	@DeleteMapping("/{key}")
	public UUID delete(@PathVariable EliminarTripulacionCommand request)
		throws Exception {
		return (UUID) _mediator.send(request).data;
	}

	@PutMapping("/deleteTripulante/{key}")
	public UUID deleteTripulante(
		@RequestBody TripulanteDto tripulanteDto,
		@PathVariable DeleteTripulanteCommand request
	) throws Exception {
		request.setTripulante(tripulanteDto);
		return (UUID) _mediator.send(request).data;
	}
}
