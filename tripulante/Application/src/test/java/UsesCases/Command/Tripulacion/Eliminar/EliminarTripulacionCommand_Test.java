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
		// dto.key = key;
		// dto.Descripcion = descripcion;
		dto.setKey(key);
		dto.setDescripcion(descripcion);

		EliminarTripulacionCommand command = new EliminarTripulacionCommand(
			dto.getKey()
		);
		Assert.assertEquals(key, command.tripulacion.getKey());
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
