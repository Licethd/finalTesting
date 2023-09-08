package UsesCases.Consumers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.Tripulacion.TripulacionDto;
import Factories.ITripulacionFactory;
import Fourteam.mediator.IMediator;
import Model.Tripulacion.Tripulacion;
import Repositories.ITripulacionRepository;
import Repositories.IUnitOfWork;
import UsesCases.Command.Tripulacion.Crear.CrearTripulacionCommand;
import UsesCases.Command.Tripulacion.Crear.CrearTripulacionHandler;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

public class VueloCreadoConsumer_Test {

	@InjectMocks
	VueloCreadoConsumer vueloCreadoConsumer;

	IMediator iMediator = Mockito.mock(IMediator.class);

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
	public void VueloCreadoConsumer() throws Exception {
		ITripulacionRepository _tripulacionRepository;
		String descripcion = "GRUPO-K";

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
		// this.tripulacionRepository = _tripulacionRepository;
		// this.vueloCreadoConsumer.Consume(entity);
	}
}
