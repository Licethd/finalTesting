package Controllers;

import Dto.Cargo.CargoDto;
import Fourteam.http.Exception.HttpException;
import Fourteam.http.annotation.*;
import Fourteam.mediator.Mediator;
import Fourteam.mediator.Response;
import Model.Tripulante.*;
import UsesCases.Command.Cargo.Crear.CrearCargoCommand;
import UsesCases.Command.Cargo.Editar.EditarCargoCommand;
import UsesCases.Command.Cargo.Eliminar.EliminarCargoCommand;
import UsesCases.Queries.Cargo.GetAll.GetAllCargoQuery;
import UsesCases.Queries.Cargo.GetByKey.GetCargoByKeyQuery;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cargo")
public class CargoController {

	private Mediator _mediator;

	public CargoController(Mediator mediator) {
		this._mediator = mediator;
	}

	@GetMapping("/")
	public List<CargoDto> getAll() throws HttpException {
		try {
			Response<List<CargoDto>> lista = _mediator.send(
				new GetAllCargoQuery()
			);
			return lista.data;
		} catch (Exception e) {
			throw (HttpException) e.getCause();
		}
		//return _mediator.send(new GetAllCargoQuery());
	}

	@GetMapping("/{key}")
	public CargoDto getByKey(@PathVariable GetCargoByKeyQuery request)
		throws Exception {
		return (CargoDto) _mediator.send(request).data;
	}

	@PostMapping("/registro")
	public UUID register(@RequestBody CrearCargoCommand cargo)
		throws Exception {
		return (UUID) _mediator.send(cargo).data;
	}

	// public Response<Cargo> register(@RequestBody CrearCargoCommand cargo) throws Exception {
	//    return _mediator.send(cargo);
	// }

	@PutMapping("/{key}")
	public CargoDto edit(
		@RequestBody Cargo cargo,
		@PathVariable EditarCargoCommand request
	) throws Exception {
		request.cargoDto.Descripcion = cargo.getDescripcion();
		return (CargoDto) _mediator.send(request).data;
	}

	// public Response<Cargo> edit(@RequestBody CargoDto cargo, @PathVariable EditarCargoCommand request) throws Exception {
	//     // request.cargoDto.Sueldo = cargo.getSueldo();
	//     request.cargoDto.Descripcion = cargo.getDescripcion();
	//     return _mediator.send(request);
	// }

	@DeleteMapping("/{key}")
	public UUID delete(@PathVariable EliminarCargoCommand request)
		throws Exception {
		return (UUID) _mediator.send(request).data;
	}
	// public  Response<Cargo> delete(@PathVariable EliminarCargoCommand request) throws Exception {
	//     return _mediator.send(request);
	// }
}
