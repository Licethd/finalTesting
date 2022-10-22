package Model.Tripulacion;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;

import Model.Tripulante.Tripulante;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tripulacion_Test {

	@Before
	public void setup() {}

	@Test
	public void constructor() {
		Assert.assertNotNull(new Tripulacion());
	}

	@Test
	public void constructor_accept() {
		String descripcion = "GRUPO-A";

		Integer estado = 1;

		Tripulacion a = new Tripulacion(descripcion);
		Assert.assertEquals(a.getDescripcion(), descripcion);
	}

	@Test
	public void addDomainEvent_accept() {
		Tripulacion a = new Tripulacion(anyString());
		a.eventCreado();
		Assert.assertEquals(a.domainEvents.size(), 1);
	}

	@Test
	public void addDomainEventChange_accept() {
		Tripulacion a = new Tripulacion(anyString());
		a.eventChange();
		Assert.assertEquals(a.domainEvents.size(), 1);
	}

	@Test
	public void addTripulante_accept() {
		String nombre = "Juan";
		String apellido = "Peres";
		String emailAddress = "jaun@gmail.com";
		String tipo = "TIERRA";
		Double horasVuelo = 52121.0;
		Double nroMillas = 1200.0;
		UUID keyCargo = UUID.randomUUID();

		Tripulacion a = new Tripulacion("GRUPO-B");
		try {
			a.agregarTripulante(
				new Tripulante(
					nombre,
					apellido,
					emailAddress,
					tipo,
					horasVuelo,
					nroMillas,
					keyCargo
				)
			);
		} catch (Exception e) {}
		// TODO://
		// Assert.assertEquals(a.asientos.size(), 1);
	}

	@Test
	public void addTripulante_denied() {
		String nombre = "Juan";
		String apellido = "Peres";
		String emailAddress = "jaun@gmail.com";
		String tipo = "TIERRA";
		Double horasVuelo = 52121.0;
		Double nroMillas = 1200.0;
		UUID keyCargo = UUID.randomUUID();

		Tripulacion a = new Tripulacion("GRUPO-D");
		Tripulante as = new Tripulante(
			nombre,
			apellido,
			emailAddress,
			tipo,
			horasVuelo,
			nroMillas,
			keyCargo
		);
		try {
			a.agregarTripulante(as);
		} catch (Exception e1) {}
		Tripulante as2 = new Tripulante(
			nombre,
			apellido,
			emailAddress,
			tipo,
			horasVuelo,
			nroMillas,
			keyCargo
		);
		as2.key = as.key;
		try {
			a.agregarTripulante(as2);
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void Handle_Ok() {
		// creando
		String descripcion = "GRUPO-C";
		Integer estado = 1;
		LocalDateTime fechaOn = LocalDateTime.now();
		List<Tripulante> Tripulantes = new ArrayList<Tripulante>();

		Tripulacion TripulacionTest = new Tripulacion();

		TripulacionTest.setDescripcion(descripcion);
		TripulacionTest.setEstado(estado);
		TripulacionTest.setTripulantes(Tripulantes);
		TripulacionTest.setFechaOn(fechaOn);

		Assert.assertEquals(descripcion, TripulacionTest.getDescripcion());
		Assert.assertEquals(estado, TripulacionTest.getEstado());
		Assert.assertEquals(fechaOn, TripulacionTest.getFechaOn());
		Assert.assertEquals(Tripulantes, TripulacionTest.getTripulantes());
	}
}
