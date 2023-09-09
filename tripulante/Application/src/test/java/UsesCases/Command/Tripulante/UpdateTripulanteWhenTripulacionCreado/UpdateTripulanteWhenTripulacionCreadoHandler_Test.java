package UsesCases.Command.Tripulante.UpdateTripulanteWhenTripulacionCreado;

import org.junit.Test;
import org.mockito.Mockito;

import Repositories.ITripulacionRepository;
import UsesCases.Command.Tripulante.Eliminar.EliminarTripulanteHandler;
import UsesCases.Consumers.VueloCreadoConsumer;

public class UpdateTripulanteWhenTripulacionCreadoHandler_Test {
	ITripulacionRepository iTripulacionRepository = Mockito.mock(
			ITripulacionRepository.class);

	@Test
	public void UpdateTripulanteWhenTripulacionCreado() {

		// new UpdateTripulanteWhenTripulacionCreadoHandler(iTripulacionRepository).handle(null);
		// this.iTripulacionRepository =

		// UpdateTripulanteWhenTripulacionCreadoHandler handler = new UpdateTripulanteWhenTripulacionCreadoHandler();
	}
}
