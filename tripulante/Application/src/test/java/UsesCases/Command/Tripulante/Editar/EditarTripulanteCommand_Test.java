package UsesCases.Command.Tripulante.Editar;

import Dto.Tripulante.TripulanteDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class EditarTripulanteCommand_Test {

	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		String nombre = "Pedro";
		TripulanteDto dto = new TripulanteDto();
		dto.key = key;
		dto.Nombre = nombre;

		EditarTripulanteCommand command = new EditarTripulanteCommand(dto.key);
		Assert.assertEquals(dto.key, command.tripulanteDto.getKey());
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
			EditarTripulanteCommand.class.getConstructors()[0].canAccess(null)
		);
	}
}
