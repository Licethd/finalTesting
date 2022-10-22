package UsesCases.Command.Tripulacion.Crear;

import Dto.Tripulacion.TripulacionDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class CrearTripulacionCommand_Test {

	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		String descripcion = "GRUPO-F";
		TripulacionDto dto = new TripulacionDto();
		dto.key = key;
		dto.setDescripcion(descripcion);

		CrearTripulacionCommand command = new CrearTripulacionCommand(dto);
		Assert.assertEquals(dto, command.tripulacionDto);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
			CrearTripulacionCommand.class.getConstructors()[0].canAccess(null)
		);
	}
}
