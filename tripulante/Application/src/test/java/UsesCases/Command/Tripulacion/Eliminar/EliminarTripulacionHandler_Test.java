package UsesCases.Command.Tripulacion.Eliminar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.Tripulacion.TripulacionDto;
import Factories.ITripulacionFactory;
import Fourteam.http.Exception.HttpException;
import Model.Tripulacion.Tripulacion;
import Repositories.ITripulacionRepository;
import Repositories.IUnitOfWork;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class EliminarTripulacionHandler_Test {

	ITripulacionFactory tripulacionFactory = Mockito.mock(
		ITripulacionFactory.class
	);
	ITripulacionRepository tripulacionRepository = Mockito.mock(
		ITripulacionRepository.class
	);
	IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

	@Before
	public void setUp() {}

	@Test
	public void HandleCorrectly() throws Exception {
		UUID key = UUID.randomUUID();
		String descripcion = "Tripulacion test1";

		Tripulacion entity = new Tripulacion(descripcion);
		entity.key = key;
		when(tripulacionRepository.Delete(any())).thenReturn(entity);
		when(tripulacionRepository.FindByKey(any())).thenReturn(entity);

		EliminarTripulacionHandler handler = new EliminarTripulacionHandler(
			tripulacionFactory,
			tripulacionRepository,
			_unitOfWork
		);

		TripulacionDto dto = new TripulacionDto();
		dto.key = key;
		dto.Descripcion = descripcion;

		EliminarTripulacionCommand command = new EliminarTripulacionCommand(
			dto.key
		);
		command.tripulacion.Descripcion = descripcion;
		UUID resp = handler.handle(command);

		Assert.assertEquals(dto.key, resp);
	}

	@Test
	public void HandleFailed() throws Exception {
		when(tripulacionRepository.FindByKey(any())).thenReturn(null);
		EliminarTripulacionHandler handler = new EliminarTripulacionHandler(
			tripulacionFactory,
			tripulacionRepository,
			_unitOfWork
		);
		TripulacionDto dto = new TripulacionDto();
		dto.Descripcion = "ABC";
		dto.key = UUID.randomUUID();
		EliminarTripulacionCommand command = new EliminarTripulacionCommand(
			dto.key
		);
		try {
			handler.handle(command);
		} catch (HttpException e) {
			Assert.assertEquals(400, e.getCode());
		}
	}
}
