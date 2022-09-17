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
    public Response<List<Tripulacion>> getAll() throws Exception {
        return _mediator.send(new GetAllTripulacionQuery());
    }

    @GetMapping("/{key}")
    public Response<TripulacionDto> getByKey(@PathVariable GetTripulacionByKeyQuery request) throws Exception {
        return _mediator.send(request);
    }


    @PostMapping("/registro")
    public Response<Tripulacion> register(@RequestBody CrearTripulacionCommand tripulacion) throws Exception {


       return _mediator.send(tripulacion);
    }

    @PutMapping("/{key}")
    public Response<Tripulacion> edit(@RequestBody TripulacionDto tripulacion, @PathVariable EditarTripulacionCommand request) throws Exception {
        // request.cargoDto.Sueldo = cargo.getSueldo();
        request.tripulacionDto.Descripcion = tripulacion.getDescripcion();
        return _mediator.send(request);
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
    public Response<Tripulacion> delete(@PathVariable EliminarTripulacionCommand request) throws Exception {
        return _mediator.send(request);
    }


}
