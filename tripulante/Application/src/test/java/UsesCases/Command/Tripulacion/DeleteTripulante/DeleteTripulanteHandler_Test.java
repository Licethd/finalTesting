package UsesCases.Command.Tripulacion.DeleteTripulante;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.Tripulacion.TripulacionDto;
import Factories.ITripulacionFactory;
import Factories.ITripulanteFactory;
import Fourteam.http.Exception.HttpException;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Tripulante;
import Repositories.ITripulacionRepository;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import UsesCases.Command.Tripulacion.Eliminar.EliminarTripulacionCommand;
import UsesCases.Command.Tripulacion.Eliminar.EliminarTripulacionHandler;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DeleteTripulanteHandler_Test {

	ITripulacionFactory tripulacionFactory = Mockito.mock(
		ITripulacionFactory.class
	);
	ITripulacionRepository tripulacionRepository = Mockito.mock(
		ITripulacionRepository.class
	);
	IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

	ITripulanteFactory tripulanteFactory = Mockito.mock(
		ITripulanteFactory.class
	);
	ITripulanteRepository tripulanteRepository = Mockito.mock(
		ITripulanteRepository.class
	);

	@Before
	public void setUp() {}

	@Test
	public void HandleCorrectly() throws Exception {
		UUID key = UUID.randomUUID();
		UUID keytripulante = UUID.randomUUID();
		String descripcion = "Tripulacion test1";
		UUID keycargo = UUID.randomUUID();

		Tripulacion tripulacion = new Tripulacion(descripcion);
		tripulacion.key = key;
		// tripulacion.Tripulante.add(tripulacion);

		Tripulante tripulante = new Tripulante();
		// tripulacion.setTripulantes(List<tripulante>);
		ArrayList<Tripulacion> miTripulacion = new ArrayList<>();
		// miTripulacion.add(tripulacion);

		tripulante.key = keytripulante;

		tripulacion.agregarTripulante(tripulante);

		// AYUDA
		when(tripulacionRepository.FindByKey(any())).thenReturn(null);
		when(tripulanteRepository.FindByKey(any())).thenReturn(null);

		// when(tripulacionRepository.FindByKey(key)).thenReturn(tripulacion);
		// when(tripulanteRepository.FindByKey(keytripulante)).thenReturn(tripulante);

		tripulacion.eliminarTripulante(key);
		tripulante.setEstado(1);

		DeleteTripulanteHandler handler = new DeleteTripulanteHandler(
			tripulacionFactory,
			tripulacionRepository,
			tripulanteFactory,
			tripulanteRepository,
			_unitOfWork
		);

		// TripulacionDto dto = new TripulacionDto();
		// dto.key = key;
		// dto.Descripcion = descripcion;

		DeleteTripulanteCommand command = new DeleteTripulanteCommand(
			tripulacion.getKey()
		);
		try {
			UUID resp = handler.handle(command);
			Assert.assertEquals(tripulacion.key, resp);
		} catch (HttpException e) {
			Assert.assertEquals(400, e.getCode());
		}
		// Assert.assertEquals(tripulacion.key, resp);
	}
	// @Test
	// public void HandleFailed() throws Exception {
	// when(tripulacionRepository.FindByKey(any())).thenReturn(null);
	// EliminarTripulacionHandler handler = new EliminarTripulacionHandler(
	// tripulacionFactory,
	// tripulacionRepository,
	// _unitOfWork
	// );
	// TripulacionDto dto = new TripulacionDto();
	// dto.Descripcion = "ABC";
	// dto.key = UUID.randomUUID();
	// EliminarTripulacionCommand command = new EliminarTripulacionCommand(
	// dto.key
	// );
	// try {
	// handler.handle(command);
	// } catch (HttpException e) {
	// Assert.assertEquals(400, e.getCode());
	// }
	// }

}
