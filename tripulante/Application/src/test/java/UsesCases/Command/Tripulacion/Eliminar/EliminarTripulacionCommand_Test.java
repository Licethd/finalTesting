package UsesCases.Command.Tripulacion.Eliminar;

import Dto.Tripulacion.TripulacionDto;
// import Dto.TripulacionDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class EliminarTripulacionCommand_Test {

	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		String descripcion = "Tripulacion Test";
		TripulacionDto dto = new TripulacionDto();
		dto.key = key;
		dto.Descripcion = descripcion;

		EliminarTripulacionCommand command = new EliminarTripulacionCommand(
			dto.key
		);
		Assert.assertEquals(dto.key, command.tripulacion.key);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
			EliminarTripulacionCommand.class.getConstructors()[0].canAccess(
					null
				)
		);
	}
}
