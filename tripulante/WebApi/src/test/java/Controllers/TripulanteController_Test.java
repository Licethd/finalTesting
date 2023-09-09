package Controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;

import Dto.Tripulante.TripulanteDto;
import Fourteam.mediator.IMediator;
import Fourteam.mediator.Response;
import Model.Tripulante.Tripulante;
import UsesCases.Command.Tripulante.Crear.CrearTripulanteCommand;
import UsesCases.Command.Tripulante.Editar.EditarTripulanteCommand;
import UsesCases.Command.Tripulante.Eliminar.EliminarTripulanteCommand;
import UsesCases.Queries.Tripulante.GetByKey.GetTripulanteByKeyQuery;


public class TripulanteController_Test {
	IMediator iMediator = Mockito.mock(IMediator.class);

	@Test
	public void Constructor() {
		new TripulanteController(iMediator);
	}


	@Test
	public void getAll() throws Exception {
	  // verify(WebApi.AddControllers());
	  when(iMediator.send(any())).thenReturn(new Response<>());
	  new TripulanteController(iMediator).getAll();
	}


	@Test
	public void getByKey() throws Exception {
	  // verify(WebApi.AddControllers());
	  when(iMediator.send(any())).thenReturn(new Response<>());
	  new TripulanteController(iMediator).getByKey(new GetTripulanteByKeyQuery(UUID.randomUUID()));
	}

	@Test
	public void register() throws Exception {
	  // verify(WebApi.AddControllers());
	  when(iMediator.send(any())).thenReturn(new Response<>());
	  new TripulanteController(iMediator).register(new CrearTripulanteCommand(new TripulanteDto()));
	}

	@Test
	public void edit() throws Exception {
	  // verify(WebApi.AddControllers());
	  when(iMediator.send(any())).thenReturn(new Response<>());
	  new TripulanteController(iMediator).edit(new Tripulante(), new EditarTripulanteCommand(UUID.randomUUID()));
	}

	@Test
	public void delete() throws Exception {
	  // verify(WebApi.AddControllers());
	  when(iMediator.send(any())).thenReturn(new Response<>());
	  new TripulanteController(iMediator).delete(new EliminarTripulanteCommand(UUID.randomUUID()));
	}
}
