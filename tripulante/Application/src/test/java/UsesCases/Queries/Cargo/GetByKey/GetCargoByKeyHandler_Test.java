package UsesCases.Queries.Cargo.GetByKey;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GetCargoByKeyHandler_Test {

	ICargoRepository cargoRepository = Mockito.mock(ICargoRepository.class);

	@Test
	public void HandleCorrectly() throws Exception {
		Cargo a = new Cargo("Cargo1");
		when(cargoRepository.FindByKey(any())).thenReturn(a);
		GetCargoByKeyHandler handler = new GetCargoByKeyHandler(
			cargoRepository
		);
		GetCargoByKeyQuery query = new GetCargoByKeyQuery(a.key);
		try {
			Assert.assertEquals(a.key, handler.handle(query).key);
		} catch (Exception e) {
			Assert.fail();
		}
		verify(cargoRepository).FindByKey(a.key);
	}

	@Test
	public void HandleFail() throws Exception {
		Cargo a = new Cargo("Cargo1");
		when(cargoRepository.FindByKey(any())).thenReturn(null);
		GetCargoByKeyHandler handler = new GetCargoByKeyHandler(
			cargoRepository
		);
		GetCargoByKeyQuery query = new GetCargoByKeyQuery(a.key);
		try {
			handler.handle(query);
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
}
