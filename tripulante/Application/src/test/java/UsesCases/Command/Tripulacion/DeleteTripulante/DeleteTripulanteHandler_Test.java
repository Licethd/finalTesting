package UsesCases.Command.Tripulacion.DeleteTripulante;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.Tripulacion.TripulacionDto;
import Dto.Tripulante.TripulanteDto;
import Factories.ITripulacionFactory;
import Factories.ITripulanteFactory;
import Fourteam.http.HttpStatus;
import Fourteam.http.Exception.HttpException;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Tripulante;
import Repositories.ITripulacionRepository;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import UsesCases.Command.Tripulacion.Eliminar.EliminarTripulacionCommand;
import UsesCases.Command.Tripulacion.Eliminar.EliminarTripulacionHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DeleteTripulanteHandler_Test {

	ITripulacionFactory tripulacionFactory = Mockito.mock(
			ITripulacionFactory.class);
	ITripulacionRepository tripulacionRepository = Mockito.mock(
			ITripulacionRepository.class);
	IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

	ITripulanteFactory tripulanteFactory = Mockito.mock(
			ITripulanteFactory.class);
	ITripulanteRepository tripulanteRepository = Mockito.mock(
			ITripulanteRepository.class);

	@Before
	public void setUp() {
	}

	@Test
	public void HandleCorrectly() throws Exception {
		UUID key = UUID.randomUUID();
		UUID keytripulante = UUID.randomUUID();
		String descripcion = "Tripulacion test1";
		UUID keycargo = UUID.randomUUID();

		Tripulacion tripulacion = new Tripulacion(descripcion);
		tripulacion.key = key;
		// tripulacion.Tripulante.add(tripulacion);

		Tripulante tripulante = new Tripulante("Angelica", "Morales", "ange@gmail.com", "TIERRA", 25.6, 526.3,
				UUID.randomUUID());
		TripulanteDto tripulanteDto = new TripulanteDto(UUID.randomUUID(), "Angelica", "Morales", "ange@gmail.com",
				"TIERRA", 25.6, 526.3,
				UUID.randomUUID());

		// tripulacion.setTripulantes(List<tripulante>);
		// ArrayList<Tripulacion> miTripulacion = new ArrayList<>();

		// Tripulacion a = new Tripulacion("Nombre tripulacion");
		// List<Tripulacion> list = new ArrayList<Tripulacion>();
		// list.add(a);
		// miTripulacion.add(tripulante);
		// tripulacion.Tripulantes.add(0, tripulante);
		// tripulante.

		// tripulante.key = keytripulante;

		tripulacion.agregarTripulante(tripulante);

		// AYUDA
		when(tripulacionRepository.FindByKey(tripulacion.key)).thenReturn(new Tripulacion("asdsad"));

		DeleteTripulanteHandler handler = new DeleteTripulanteHandler(
				tripulacionFactory,
				tripulacionRepository,
				tripulanteFactory,
				tripulanteRepository,
				_unitOfWork);

		// TripulacionDto dto = new TripulacionDto();
		// dto.key = key;
		// dto.Descripcion = descripcion;

		DeleteTripulanteCommand command = new DeleteTripulanteCommand(
				tripulacion.getKey());
		command.setTripulante(tripulanteDto);
		when(tripulanteRepository.FindByKey(command.Tripulante.key))
				.thenReturn(new Tripulante("", "", "", "", 0.1, 0.1, UUID.randomUUID()));

		// tripulacion.eliminarTripulante(tripulante.key);
		tripulante.setEstado(1);

		try {

			UUID resp = handler.handle(command);
			Assert.assertNotNull(resp);
			// Assert.assertEquals(tripulante.key, resp);
		} catch (HttpException e) {
			Assert.assertEquals(400, e.getCode());
		}

		// Assert.assertEquals(tripulacion.key, resp);

		// Assert.assertNotNull(command);
		// when(tripulanteRepository.FindByKey(command.Tripulante.getKey())).thenReturn(tripulacion.getTripulantes().get(0));

		// if (tripulanteRepository.FindByKey(command.Tripulante.getKey()) == null) {
		// throw new HttpException(
		// HttpStatus.BAD_REQUEST,
		// "Tripulante no encontrado");
		// }
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
