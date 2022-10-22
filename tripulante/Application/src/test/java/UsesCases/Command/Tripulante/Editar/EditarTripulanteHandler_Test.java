package UsesCases.Command.Tripulante.Editar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.Tripulante.TripulanteDto;
import Factories.ITripulanteFactory;
import Fourteam.http.Exception.HttpException;
import Model.Tripulante.Tripulante;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class EditarTripulanteHandler_Test {

	ITripulanteFactory tripulanteFactory = Mockito.mock(
		ITripulanteFactory.class
	);
	ITripulanteRepository tripulanteRepository = Mockito.mock(
		ITripulanteRepository.class
	);
	IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

	@Before
	public void setUp() {}

	@Test
	public void HandleCorrectly() throws Exception {
		UUID key = UUID.randomUUID();
		String nombre = "Julio";
		String apellido = "Morales";
		String emailAddress = "juanito@gmail.com";
		String estado = "1";
		String tipo = "AIRE";
		Double horasVuelo = 1522.0;
		Double nroMillas = 1522.0;
		UUID keyCargo = UUID.randomUUID();

		Tripulante entity = new Tripulante(
			nombre,
			apellido,
			emailAddress,
			tipo,
			horasVuelo,
			nroMillas,
			keyCargo
		);
		entity.key = key;
		// when(tripulanteFactory.Create(nombre)).thenReturn(entity);
		when(tripulanteRepository.FindByKey(any())).thenReturn(entity);

		EditarTripulanteHandler handler = new EditarTripulanteHandler(
			tripulanteFactory,
			tripulanteRepository,
			_unitOfWork
		);

		TripulanteDto dto = new TripulanteDto();
		dto.key = key;
		dto.Nombre = nombre;

		EditarTripulanteCommand command = new EditarTripulanteCommand(dto.key);
		command.tripulanteDto.Nombre = nombre;
		TripulanteDto resp = handler.handle(command);

		Assert.assertEquals(nombre, resp.Nombre);
	}

	@Test
	public void HandleFailed() throws Exception {
		when(tripulanteRepository.FindByKey(any())).thenReturn(null);
		EditarTripulanteHandler handler = new EditarTripulanteHandler(
			tripulanteFactory,
			tripulanteRepository,
			_unitOfWork
		);
		TripulanteDto dto = new TripulanteDto();
		dto.Nombre = "Julio";
		dto.key = UUID.randomUUID();
		EditarTripulanteCommand command = new EditarTripulanteCommand(dto.key);
		try {
			handler.handle(command);
		} catch (HttpException e) {
			Assert.assertEquals(400, e.getCode());
		}
	}
}
