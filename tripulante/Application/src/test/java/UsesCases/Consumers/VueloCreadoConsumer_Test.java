package UsesCases.Consumers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.Tripulacion.TripulacionDto;
import Factories.ITripulacionFactory;
import Fourteam.mediator.IMediator;
import IntegrationEvents.VueloCreado;
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
			ITripulacionFactory.class);
	ITripulacionRepository tripulacionRepository = Mockito.mock(
			ITripulacionRepository.class);
	IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

	VueloCreado objeto = new VueloCreado();


	@Before
	public void setUp() {
	}

	@Test
	public void VueloCreadoConsumer() throws Exception {
		// ITripulacionRepository _tripulacionRepository;
		 String descripcion = "GRUPO-K";

		Tripulacion tripulacion = new Tripulacion(descripcion);
		// when(tripulacionFactory.Create(descripcion)).thenReturn(entity);

		// CrearTripulacionHandler handler = new CrearTripulacionHandler(
		// tripulacionFactory,
		// tripulacionRepository,
		// _unitOfWork
		// );

		// TripulacionDto dto = new TripulacionDto();
		// dto.Descripcion = descripcion;

		// CrearTripulacionCommand command = new CrearTripulacionCommand(dto);
		// UUID resp = handler.handle(command);

		// verify(_unitOfWork).commit();
		// Assert.assertNotNull(resp);

		new VueloCreadoConsumer(iMediator, tripulacionRepository).Consume(objeto);

		tripulacion.setEstado(anyInt());
		tripulacionRepository.Update(tripulacion);

	}
}
