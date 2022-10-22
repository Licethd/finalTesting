package UsesCases.Command.Cargo.Crear;

import Dto.Cargo.CargoDto;
import UsesCases.Command.Cargo.Crear.CrearCargoCommand;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class CrearCargoCommand_Test {

	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		String descripcion = "Asistente";
		CargoDto dto = new CargoDto();
		dto.key = key;
		dto.setDescripcion(descripcion);

		CrearCargoCommand command = new CrearCargoCommand(dto);
		Assert.assertEquals(dto, command.cargoDto);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
			CrearCargoCommand.class.getConstructors()[0].canAccess(null)
		);
	}
}
