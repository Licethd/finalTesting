package Event;

import static org.mockito.ArgumentMatchers.anyDouble;

import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Tripulante;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class PersonalRegistrado_Test {

	@Test
	public void Constructor_accept() {
		Tripulante a = new Tripulante();
		Assert.assertNotNull(new PersonalRegistrado(a.key, a.getNombre()));
	}

	@Test
	public void ConstructorGetSet_accept() {
		Tripulante a = new Tripulante(
			"Juan",
			"Flores",
			"juan@gmail.com",
			"AIRE",
			anyDouble(),
			anyDouble(),
			UUID.randomUUID()
		);
		PersonalRegistrado c = new PersonalRegistrado(a.key, a.getNombre());
		c.setNombre(a.getNombre());
		Assert.assertEquals("Juan", c.getNombre());
	}
}
