package UsesCases.Command.Tripulacion.Editar;

import Dto.Tripulacion.TripulacionDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class EditarTripulacionCommand_Test {

	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		String descripcion = "Piloto";
		TripulacionDto dto = new TripulacionDto();
		dto.key = key;
		dto.Descripcion = descripcion;

		EditarTripulacionCommand command = new EditarTripulacionCommand(
			dto.key
		);
		Assert.assertEquals(dto.key, command.tripulacionDto.key);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
			EditarTripulacionCommand.class.getConstructors()[0].canAccess(null)
		);
	}
}
