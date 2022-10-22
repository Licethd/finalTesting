package UsesCases.Command.Tripulacion.AddTripulante;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.Cargo.CargoDto;
import Dto.Tripulacion.TripulacionDto;
import Factories.ICargoFactory;
import Factories.ITripulacionFactory;
import Factories.ITripulanteFactory;
import Fourteam.http.Exception.HttpException;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import Repositories.ITripulacionRepository;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AddTripulanteHandler_Test {

	ITripulacionFactory tripulacionFactory = Mockito.mock(
		ITripulacionFactory.class
	);
	ITripulacionRepository tripulacionRepository = Mockito.mock(
		ITripulacionRepository.class
	);

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
		String descripcion = "GRUPO-A";

		Tripulacion entity = new Tripulacion(descripcion);
		entity.key = key;
		when(tripulacionFactory.Create(descripcion)).thenReturn(entity);
		when(tripulacionRepository.FindByKey(any())).thenReturn(entity);

		AddTripulanteHandler handler = new AddTripulanteHandler(
			tripulacionFactory,
			tripulacionRepository,
			tripulanteFactory,
			tripulanteRepository,
			_unitOfWork
		);

		TripulacionDto dto = new TripulacionDto();
		dto.key = key;
		dto.Descripcion = descripcion;

		AddTripulanteCommand command = new AddTripulanteCommand(dto.key);
		// command.Tripulante.Nombre= descripcion;
		// UUID resp = handler.handle(command);

		// Assert.assertEquals(descripcion, resp.D);
	}

	@Test
	public void HandleFailed() throws Exception {
		when(tripulacionRepository.FindByKey(any())).thenReturn(null);
		AddTripulanteHandler handler = new AddTripulanteHandler(
			tripulacionFactory,
			tripulacionRepository,
			tripulanteFactory,
			tripulanteRepository,
			_unitOfWork
		);
		TripulacionDto dto = new TripulacionDto();
		dto.Descripcion = "Asistente";
		dto.key = UUID.randomUUID();
		AddTripulanteCommand command = new AddTripulanteCommand(dto.key);
		try {
			handler.handle(command);
		} catch (HttpException e) {
			Assert.assertEquals(400, e.getCode());
		}
	}
}
