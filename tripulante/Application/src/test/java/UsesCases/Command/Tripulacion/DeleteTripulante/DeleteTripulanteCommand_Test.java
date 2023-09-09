package UsesCases.Command.Tripulacion.DeleteTripulante;

import Dto.Tripulante.TripulanteDto;
import UsesCases.Command.Tripulante.Eliminar.EliminarTripulanteCommand;
// import Dto.TripulanteDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class DeleteTripulanteCommand_Test {

	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		String descripcion = "Tripulante Test";
		TripulanteDto dto = new TripulanteDto();
		dto.key = key;
		dto.Nombre = descripcion;

		DeleteTripulanteCommand command = new DeleteTripulanteCommand(dto.key);
		Assert.assertEquals(key, command.key);

		command.setTripulante(dto);
		Assert.assertEquals(dto, command.Tripulante);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
			DeleteTripulanteCommand.class.getConstructors()[0].canAccess(null)
		);
	}
}
