package Event;

import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Tripulante;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class TripulacionChange_Test {

	@Test
	public void Constructor_accept() {
		Tripulacion a = new Tripulacion();
		Assert.assertNotNull(
			new TripulacionChange(a.key, a.getDescripcion(), a.Tripulantes)
		);
	}

	@Test
	public void ConstructorGetSet_accept() {
		Tripulacion a = new Tripulacion("GRUPO");
		TripulacionChange c = new TripulacionChange(
			a.key,
			a.getDescripcion(),
			a.getTripulantes()
		);
		c.setNombre(a.getDescripcion());
		c.setTripulantes(null);

		Assert.assertEquals("GRUPO", c.getNombre());
	}
}
