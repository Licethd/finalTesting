package UsesCases.Command.Tripulacion.Crear;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.Cargo.CargoDto;
import Dto.Tripulacion.TripulacionDto;
import Factories.ICargoFactory;
import Factories.ITripulacionFactory;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import Repositories.ITripulacionRepository;
import Repositories.IUnitOfWork;
import UsesCases.Command.Cargo.Crear.CrearCargoCommand;
import UsesCases.Command.Cargo.Crear.CrearCargoHandler;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CrearTripulacionHandler_Test {

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
		String descripcion = "GRUPO-F";

		Tripulacion entity = new Tripulacion(descripcion);
		when(tripulacionFactory.Create(descripcion)).thenReturn(entity);

		CrearTripulacionHandler handler = new CrearTripulacionHandler(
			tripulacionFactory,
			tripulacionRepository,
			_unitOfWork
		);

		TripulacionDto dto = new TripulacionDto();
		dto.Descripcion = descripcion;

		CrearTripulacionCommand command = new CrearTripulacionCommand(dto);
		UUID resp = handler.handle(command);

		// verify(marcaRepository).Create(resp);
		verify(_unitOfWork).commit();
		Assert.assertNotNull(resp);
	}
}
