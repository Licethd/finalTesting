package Model.Tripulante;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Cargo_Test {

	@Before
	public void setup() {}

	@Test
	public void constructor() {
		Assert.assertNotNull(new Cargo("Piloto"));
	}

	@Test
	public void constructor_accept() {
		String descripcion = "Piloto";
		Cargo a = new Cargo(descripcion);
		Assert.assertEquals(a.getDescripcion(), descripcion);
	}

	@Test
	public void HandleCargo_Ok() {
		// creando tripulante
		UUID keyTest = UUID.randomUUID();
		String descripcionTest = "Perez";

		Cargo CargoTest = new Cargo();
		Cargo CargoTest2 = new Cargo(anyString());

		CargoTest.setDescripcion(descripcionTest);
		CargoTest.setKeyCargo(keyTest);

		Assert.assertEquals(descripcionTest, CargoTest.getDescripcion());
	}
}
