package Model.Tripulante;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tripulante_Test {

	@Before
	public void setup() {}

	@Test
	public void constructor() {
		Assert.assertNotNull(new Tripulante());
	}

	@Test
	public void constructor_accept() {
		String nombre = "Juan";
		String apellido = "Peres";
		String emailAddress = "jaun@gmail.com";
		String tipo = "TIERRA";
		Double horasVuelo = 52121.0;
		Double nroMillas = 1200.0;
		Integer estado = 1;
		UUID keyCargo = UUID.randomUUID();

		Tripulante a = new Tripulante(
			nombre,
			apellido,
			emailAddress,
			tipo,
			horasVuelo,
			nroMillas,
			keyCargo
		);
		Assert.assertEquals(a.getNombre(), nombre);
		Assert.assertEquals(a.getApellido(), apellido);
		Assert.assertEquals(a.getEmailAddress(), emailAddress);
		Assert.assertEquals(a.getTipo(), tipo);
		Assert.assertEquals(a.getHorasVuelo(), horasVuelo);
		Assert.assertEquals(a.getNroMillas(), nroMillas);
		Assert.assertEquals(a.getKeyCargo(), keyCargo);
		Assert.assertEquals(a.getEstado(), estado);
	}

	@Test
	public void addDomainEvent_accept() {
		UUID key = UUID.randomUUID();
		Tripulante a = new Tripulante(
			anyString(),
			anyString(),
			anyString(),
			anyString(),
			anyDouble(),
			anyDouble(),
			key
		);
		a.eventCreado();
		Assert.assertEquals(a.domainEvents.size(), 1);
	}

	@Test
	public void Handle_Ok() {
		// creando tripulante
		UUID keyTest = UUID.randomUUID();
		String nombre = "Juan";
		String apellido = "Peres";
		String emailAddress = "jaun@gmail.com";
		String tipo = "TIERRA";
		Double horasVuelo = 52121.0;
		Double nroMillas = 1200.0;
		UUID keyCargo = UUID.randomUUID();
		Integer estado = 1;
		UUID key = UUID.randomUUID();

		Tripulante TripulanteTest = new Tripulante();
		Tripulante TripulanteTest2 = new Tripulante();

		TripulanteTest.setNombre(nombre);
		TripulanteTest.setApellido(apellido);
		TripulanteTest.setEmailAddress(emailAddress);
		TripulanteTest.setTipo(tipo);
		TripulanteTest.setHorasVuelo(horasVuelo);
		TripulanteTest.setNroMillas(nroMillas);
		TripulanteTest.setKeyCargo(keyCargo);
		TripulanteTest.setKey(keyTest);
		TripulanteTest.setEstado(estado);
		TripulanteTest.setKey(TripulanteTest2.getKey());
	}
}
