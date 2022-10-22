package UsesCases.Command.Cargo.Editar;

import Dto.Cargo.CargoDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class EditarCargoCommand_Test {

	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		String descripcion = "Piloto";
		CargoDto dto = new CargoDto();
		dto.key = key;
		dto.Descripcion = descripcion;

		EditarCargoCommand command = new EditarCargoCommand(dto.key);
		Assert.assertEquals(dto.key, command.cargoDto.key);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
			EditarCargoCommand.class.getConstructors()[0].canAccess(null)
		);
	}
}
