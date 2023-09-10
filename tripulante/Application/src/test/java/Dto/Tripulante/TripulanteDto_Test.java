package Dto.Tripulante;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class TripulanteDto_Test {

	@Test
	public void CheckPropertiesValid() {
		UUID key = UUID.randomUUID();
		String nombre = "Juanito";
		String apellido = "Morales";
		String emailAddress = "juanito@gmail.com";
		String estado = "1";
		String tipo = "AIRE";
		Double horasVuelo = 1522.0;
		Double nroMillas = 1522.0;

		UUID keyCargo = UUID.randomUUID();
		TripulanteDto tripulante = new TripulanteDto(
			null,
			null,
			null,
			null,
			null,
			null,
			null,
			null
		);
		tripulante.setEstado("1");
		tripulante.getEstado();

		Assert.assertEquals(null, tripulante.getKey());
		Assert.assertNull(tripulante.getNombre());
		Assert.assertNull(tripulante.getApellido());
		Assert.assertNull(tripulante.getEmailAddress());
		Assert.assertNull(tripulante.getKeyCargo());
		Assert.assertNull(tripulante.getHorasVuelo());
		Assert.assertNull(tripulante.getNroMillas());
		Assert.assertNull(tripulante.getTipo());

		tripulante.setKey(key);
		tripulante.setNombre(nombre);
		tripulante.setApellido(apellido);
		tripulante.setEmailAddress(emailAddress);
		tripulante.setKeyCargo(UUID.randomUUID());
		tripulante.setEstado(estado);
		tripulante.setNroMillas(nroMillas);
		tripulante.setHorasVuelo(horasVuelo);
		tripulante.setTipo(tipo);


		//falta el dar los valores de ejemplo
		Assert.assertEquals(key, tripulante.getKey());
		Assert.assertEquals(nombre, tripulante.getNombre());
		Assert.assertEquals(apellido, tripulante.getApellido());
		Assert.assertEquals(emailAddress, tripulante.getEmailAddress());

	}
}
