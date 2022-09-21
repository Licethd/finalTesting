package Controllers;

import java.util.List;
import java.util.UUID;

import Dto.Tripulacion.TripulacionDto;
import Dto.Tripulante.TripulanteDto;
import UsesCases.Command.Tripulacion.AddTripulante.AddTripulanteCommand;
import UsesCases.Command.Tripulacion.Crear.CrearTripulacionCommand;
import UsesCases.Command.Tripulacion.Editar.EditarTripulacionCommand;
import UsesCases.Command.Tripulacion.Eliminar.EliminarTripulacionCommand;
import UsesCases.Queries.Tripulacion.GetAll.GetAllTripulacionQuery;
import UsesCases.Queries.Tripulacion.GetByKey.GetTripulacionByKeyQuery;
import Model.Tripulacion.Tripulacion;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.annotation.*;
import Fourteam.mediator.Mediator;
import Fourteam.mediator.Response;

@RestController
@RequestMapping("/tripulacion")
public class TripulacionController {

	private Mediator _mediator;

	public TripulacionController(Mediator mediator) {
		this._mediator = mediator;
	}

	@GetMapping("/")
	public List<TripulacionDto> getAll() throws HttpException {
		try {
			Response<List<TripulacionDto>> lista = _mediator.send(new GetAllTripulacionQuery());
			return lista.data;
		} catch (Exception e) {
			throw (HttpException) e.getCause();
		}
	}


	@GetMapping("/{key}")
	public Response<TripulacionDto> getByKey(@PathVariable GetTripulacionByKeyQuery request)
			throws HttpException {
		try {
			return _mediator.send(request);
		} catch (Exception e) {
			throw (HttpException) e.getCause();
		}
	}


	@PostMapping("/registro")
	public UUID register(@RequestBody CrearTripulacionCommand tripulacion) throws Exception {

		return (UUID) _mediator.send(tripulacion).data;
		// return _mediator.send(tripulacion);
	}

	@PutMapping("/{key}")
	public TripulacionDto edit(
			@RequestBody Tripulacion tripulacion,
			@PathVariable EditarTripulacionCommand request) throws HttpException {
		request.tripulacionDto.Descripcion = tripulacion.getDescripcion();
		try {
			return (TripulacionDto) _mediator.send(request).data;
		} catch (Exception e) {
			throw (HttpException) e.getCause();
		}
	}

	@PutMapping("/addTripulante/{key}")
	public UUID addTripulante(
			@RequestBody TripulanteDto tripulanteDto,
			@PathVariable AddTripulanteCommand request) throws Exception {
		request.setTripulante(tripulanteDto);
		return (UUID) _mediator.send(request).data;
	}

	@DeleteMapping("/{key}")
	public UUID delete(@PathVariable EliminarTripulacionCommand request) throws HttpException {
		try {
			return (UUID) _mediator.send(request).data;
		} catch (Exception e) {
			throw (HttpException) e.getCause();
		}
	}


}
