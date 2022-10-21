package Dto.Cargo;

import Dto.Cargo.CargoDto;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class CargoDto_Test {

	@Test
	public void CargoCheckPropertiesValid() {
		String descripcion = "Asistente";
		CargoDto cargo2 = new CargoDto();
		CargoDto cargo = new CargoDto(null, null);

		Assert.assertNull(cargo.Descripcion);

		cargo.setDescripcion(descripcion);
		cargo.setKey(cargo2.getKey());

		Assert.assertEquals(descripcion, cargo.getDescripcion());
	}
}
