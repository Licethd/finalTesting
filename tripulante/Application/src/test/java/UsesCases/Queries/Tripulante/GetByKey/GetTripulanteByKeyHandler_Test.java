package UsesCases.Queries.Tripulante.GetByKey;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Model.Tripulante.Tripulante;
import Repositories.ITripulanteRepository;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GetTripulanteByKeyHandler_Test {

	ITripulanteRepository tripulanteRepository = Mockito.mock(
		ITripulanteRepository.class
	);

	@Test
	public void HandleCorrectly() throws Exception {
		Tripulante a = new Tripulante(
			"Juan",
			"Flores",
			"aa@gmail.com",
			"AIRE",
			15.0,
			65.0,
			UUID.randomUUID()
		);
		when(tripulanteRepository.FindByKey(any())).thenReturn(a);
		GetTripulanteByKeyHandler handler = new GetTripulanteByKeyHandler(
			tripulanteRepository
		);
		GetTripulanteByKeyQuery query = new GetTripulanteByKeyQuery(a.key);
		try {
			Assert.assertEquals(a.key, handler.handle(query).key);
		} catch (Exception e) {
			Assert.fail();
		}
		verify(tripulanteRepository).FindByKey(a.key);
	}

	@Test
	public void HandleFail() throws Exception {
		Tripulante a = new Tripulante(
			"Juan",
			"Flores",
			"aa@gmail.com",
			"AIRE",
			15.0,
			65.0,
			UUID.randomUUID()
		);
		when(tripulanteRepository.FindByKey(any())).thenReturn(null);
		GetTripulanteByKeyHandler handler = new GetTripulanteByKeyHandler(
			tripulanteRepository
		);
		GetTripulanteByKeyQuery query = new GetTripulanteByKeyQuery(a.key);
		try {
			handler.handle(query);
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
}
