package UsesCases.Command.Tripulante.Eliminar;

import Dto.Tripulante.TripulanteDto;
// import Dto.TripulanteDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class EliminarTripulanteCommand_Test {

	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		String descripcion = "Tripulante Test";
		TripulanteDto dto = new TripulanteDto();
		dto.key = key;
		dto.Nombre = descripcion;

		EliminarTripulanteCommand command = new EliminarTripulanteCommand(
			dto.key
		);
		Assert.assertEquals(dto.key, command.tripulante.key);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
			EliminarTripulanteCommand.class.getConstructors()[0].canAccess(null)
		);
	}
}
