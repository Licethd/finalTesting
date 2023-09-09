package Controllers;

import org.mockito.Mockito;

import Dto.Cargo.CargoDto;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;

import Fourteam.mediator.IMediator;
import Fourteam.mediator.Response;
import Model.Tripulante.Cargo;
import UsesCases.Command.Cargo.Crear.CrearCargoCommand;
import UsesCases.Command.Cargo.Editar.EditarCargoCommand;
import UsesCases.Command.Cargo.Eliminar.EliminarCargoCommand;
import UsesCases.Queries.Cargo.GetByKey.GetCargoByKeyQuery;

public class CargoController_Test {

	IMediator iMediator = Mockito.mock(IMediator.class);

	@Test
	public void Constructor() {
		new CargoController(iMediator);
	}


	@Test
	public void getAll() throws Exception {
	  // verify(WebApi.AddControllers());
	  when(iMediator.send(any())).thenReturn(new Response<>());
	  new CargoController(iMediator).getAll();
	}


	@Test
	public void getByKey() throws Exception {
	  // verify(WebApi.AddControllers());
	  when(iMediator.send(any())).thenReturn(new Response<>());
	  new CargoController(iMediator).getByKey(new GetCargoByKeyQuery(UUID.randomUUID()));
	}

	@Test
	public void register() throws Exception {
	  // verify(WebApi.AddControllers());
	  when(iMediator.send(any())).thenReturn(new Response<>());
	  new CargoController(iMediator).register(new CrearCargoCommand(new CargoDto()));
	}

	@Test
	public void edit() throws Exception {
	  // verify(WebApi.AddControllers());
	  when(iMediator.send(any())).thenReturn(new Response<>());
	  new CargoController(iMediator).edit(new Cargo("Asistente"), new EditarCargoCommand(UUID.randomUUID()));
	}

	@Test
	public void delete() throws Exception {
	  // verify(WebApi.AddControllers());
	  when(iMediator.send(any())).thenReturn(new Response<>());
	  new CargoController(iMediator).delete(new EliminarCargoCommand(UUID.randomUUID()));
	}
}
