package Dto.Tripulacion;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class TripulacionDto_Test {

	@Test
	public void TripulacionCheckPropertiesValid() {
		String descripcion = "GRUPO-C";
		TripulacionDto tripulacion2 = new TripulacionDto();
		TripulacionDto tripulacion = new TripulacionDto(
			UUID.randomUUID(),
			"GRUPO-C"
		);

		tripulacion.setDescripcion(descripcion);
		tripulacion.setKey(tripulacion2.getKey());
		tripulacion.setEstado(tripulacion2.getEstado());
		tripulacion.setTripulantes(tripulacion2.getTripulantes());

		Assert.assertEquals(descripcion, tripulacion.getDescripcion());
	}
}
