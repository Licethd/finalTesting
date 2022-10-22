package UsesCases.Queries.Tripulacion.GetByKey;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Model.Tripulacion.Tripulacion;
import Repositories.ITripulacionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GetTripulacionByKeyHandler_Test {

	ITripulacionRepository tripulacionRepository = Mockito.mock(
		ITripulacionRepository.class
	);

	@Test
	public void HandleCorrectly() throws Exception {
		Tripulacion a = new Tripulacion("Tripulacion1");
		when(tripulacionRepository.FindByKey(any())).thenReturn(a);
		GetTripulacionByKeyHandler handler = new GetTripulacionByKeyHandler(
			tripulacionRepository
		);
		GetTripulacionByKeyQuery query = new GetTripulacionByKeyQuery(a.key);
		try {
			Assert.assertEquals(a.key, handler.handle(query).key);
		} catch (Exception e) {
			Assert.fail();
		}
		verify(tripulacionRepository).FindByKey(a.key);
	}

	@Test
	public void HandleFail() throws Exception {
		Tripulacion a = new Tripulacion("Tripulacion1");
		when(tripulacionRepository.FindByKey(any())).thenReturn(null);
		GetTripulacionByKeyHandler handler = new GetTripulacionByKeyHandler(
			tripulacionRepository
		);
		GetTripulacionByKeyQuery query = new GetTripulacionByKeyQuery(a.key);
		try {
			handler.handle(query);
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
}
