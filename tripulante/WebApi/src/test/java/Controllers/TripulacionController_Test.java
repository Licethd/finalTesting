package Controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;

import Dto.Tripulacion.TripulacionDto;
import Dto.Tripulante.TripulanteDto;
import Fourteam.mediator.IMediator;
import Fourteam.mediator.Response;
import Model.Tripulacion.Tripulacion;
import UsesCases.Command.Tripulacion.AddTripulante.AddTripulanteCommand;
import UsesCases.Command.Tripulacion.Crear.CrearTripulacionCommand;
import UsesCases.Command.Tripulacion.DeleteTripulante.DeleteTripulanteCommand;
import UsesCases.Command.Tripulacion.Editar.EditarTripulacionCommand;
import UsesCases.Command.Tripulacion.Eliminar.EliminarTripulacionCommand;
import UsesCases.Queries.Tripulacion.GetByKey.GetTripulacionByKeyQuery;

public class TripulacionController_Test {
	IMediator iMediator = Mockito.mock(IMediator.class);

	@Test
	public void Constructor() {
		new TripulacionController(iMediator);
	}


	@Test
	public void getAll() throws Exception {
	  // verify(WebApi.AddControllers());
	  when(iMediator.send(any())).thenReturn(new Response<>());
	  new TripulacionController(iMediator).getAll();
	}


	@Test
	public void getByKey() throws Exception {
	  // verify(WebApi.AddControllers());
	  when(iMediator.send(any())).thenReturn(new Response<>());
	  new TripulacionController(iMediator).getByKey(new GetTripulacionByKeyQuery(UUID.randomUUID()));
	}

	@Test
	public void register() throws Exception {
	  // verify(WebApi.AddControllers());
	  when(iMediator.send(any())).thenReturn(new Response<>());
	  new TripulacionController(iMediator).register(new CrearTripulacionCommand(new TripulacionDto()));
	}

	@Test
	public void edit() throws Exception {
	  // verify(WebApi.AddControllers());
	  when(iMediator.send(any())).thenReturn(new Response<>());
	  new TripulacionController(iMediator).edit(new Tripulacion(), new EditarTripulacionCommand(UUID.randomUUID()));
	}

	@Test
	public void addTripulante() throws Exception {
	  // verify(WebApi.AddControllers());
	  when(iMediator.send(any())).thenReturn(new Response<>());
	  new TripulacionController(iMediator).addTripulante(new TripulanteDto(),  new AddTripulanteCommand(UUID.randomUUID()));
	}

	@Test
	public void deleteTripulante() throws Exception {
	  // verify(WebApi.AddControllers());
	  when(iMediator.send(any())).thenReturn(new Response<>());
	  new TripulacionController(iMediator).deleteTripulante(new TripulanteDto(),  new DeleteTripulanteCommand(UUID.randomUUID()));
	}

		@Test
	public void delete() throws Exception {
	  // verify(WebApi.AddControllers());
	  when(iMediator.send(any())).thenReturn(new Response<>());
	  new TripulacionController(iMediator).delete(new EliminarTripulacionCommand(UUID.randomUUID()));
	}
}
