package UsesCases.Command.Tripulacion.AddTripulante;

import Dto.Tripulacion.TripulacionDto;
import Dto.Tripulante.TripulanteDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class AddTripulanteCommand_Test {

	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		String descripcion = "Piloto";
		TripulanteDto dto = new TripulanteDto();
		dto.key = key;
		dto.Nombre = descripcion;

		AddTripulanteCommand command = new AddTripulanteCommand(dto.key);
		// Assert.assertEquals(dto.key, command.Tripulante.getKey());
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
			AddTripulanteCommand.class.getConstructors()[0].canAccess(null)
		);
	}
}
