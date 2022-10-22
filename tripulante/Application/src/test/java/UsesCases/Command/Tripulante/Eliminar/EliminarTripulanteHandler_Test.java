package UsesCases.Command.Tripulante.Eliminar;

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

public class EliminarTripulanteHandler_Test {

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
		String descripcion = "Tripulante test1";

		Tripulante entity = new Tripulante(
			"Juan",
			"Flores",
			"aa@gmail.com",
			"AIRE",
			15.0,
			65.0,
			UUID.randomUUID()
		);
		entity.key = key;
		when(tripulanteRepository.Delete(any())).thenReturn(entity);
		when(tripulanteRepository.FindByKey(any())).thenReturn(entity);

		EliminarTripulanteHandler handler = new EliminarTripulanteHandler(
			tripulanteFactory,
			tripulanteRepository,
			_unitOfWork
		);

		TripulanteDto dto = new TripulanteDto();
		dto.key = key;
		dto.Nombre = descripcion;

		EliminarTripulanteCommand command = new EliminarTripulanteCommand(
			dto.key
		);
		command.tripulante.Nombre = descripcion;
		UUID resp = handler.handle(command);

		Assert.assertEquals(dto.key, resp);
	}

	@Test
	public void HandleFailed() throws Exception {
		when(tripulanteRepository.FindByKey(any())).thenReturn(null);
		EliminarTripulanteHandler handler = new EliminarTripulanteHandler(
			tripulanteFactory,
			tripulanteRepository,
			_unitOfWork
		);
		TripulanteDto dto = new TripulanteDto();
		dto.Nombre = "ABC";
		dto.key = UUID.randomUUID();
		EliminarTripulanteCommand command = new EliminarTripulanteCommand(
			dto.key
		);
		try {
			handler.handle(command);
		} catch (HttpException e) {
			Assert.assertEquals(400, e.getCode());
		}
	}
}
