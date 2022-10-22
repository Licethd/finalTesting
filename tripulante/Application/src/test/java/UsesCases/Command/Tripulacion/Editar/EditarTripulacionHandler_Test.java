package UsesCases.Command.Tripulacion.Editar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.Cargo.CargoDto;
import Dto.Tripulacion.TripulacionDto;
import Factories.ICargoFactory;
import Factories.ITripulacionFactory;
import Fourteam.http.Exception.HttpException;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import Repositories.ITripulacionRepository;
import Repositories.IUnitOfWork;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class EditarTripulacionHandler_Test {

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
		String descripcion = "GRUPO-A";

		Tripulacion entity = new Tripulacion(descripcion);
		entity.key = key;
		when(tripulacionFactory.Create(descripcion)).thenReturn(entity);
		when(tripulacionRepository.FindByKey(any())).thenReturn(entity);

		EditarTripulacionHandler handler = new EditarTripulacionHandler(
			tripulacionFactory,
			tripulacionRepository,
			_unitOfWork
		);

		CargoDto dto = new CargoDto();
		dto.key = key;
		dto.Descripcion = descripcion;

		EditarTripulacionCommand command = new EditarTripulacionCommand(
			dto.key
		);
		command.tripulacionDto.Descripcion = descripcion;
		TripulacionDto resp = handler.handle(command);

		Assert.assertEquals(descripcion, resp.Descripcion);
	}

	@Test
	public void HandleFailed() throws Exception {
		when(tripulacionRepository.FindByKey(any())).thenReturn(null);
		EditarTripulacionHandler handler = new EditarTripulacionHandler(
			tripulacionFactory,
			tripulacionRepository,
			_unitOfWork
		);
		TripulacionDto dto = new TripulacionDto();
		dto.Descripcion = "Asistente";
		dto.key = UUID.randomUUID();
		EditarTripulacionCommand command = new EditarTripulacionCommand(
			dto.key
		);
		try {
			handler.handle(command);
		} catch (HttpException e) {
			Assert.assertEquals(400, e.getCode());
		}
	}
}
