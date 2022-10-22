package UsesCases.Command.Cargo.Eliminar;

import Dto.Cargo.CargoDto;
// import Dto.CargoDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class EliminarCargoCommand_Test {

	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		String descripcion = "Cargo Test";
		CargoDto dto = new CargoDto();
		dto.key = key;
		dto.Descripcion = descripcion;

		EliminarCargoCommand command = new EliminarCargoCommand(dto.key);
		Assert.assertEquals(dto.key, command.cargo.key);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
			EliminarCargoCommand.class.getConstructors()[0].canAccess(null)
		);
	}
}
