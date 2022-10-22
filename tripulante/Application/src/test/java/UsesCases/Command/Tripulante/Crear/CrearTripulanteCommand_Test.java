package UsesCases.Command.Tripulante.Crear;

import Dto.Tripulacion.TripulacionDto;
import Dto.Tripulante.TripulanteDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class CrearTripulanteCommand_Test {

	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		String nombre = "Julio";
		TripulanteDto dto = new TripulanteDto();
		dto.key = key;
		dto.setNombre(nombre);

		CrearTripulanteCommand command = new CrearTripulanteCommand(dto);
		Assert.assertEquals(dto, command.tripulanteDto);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
			CrearTripulanteCommand.class.getConstructors()[0].canAccess(null)
		);
	}
}
