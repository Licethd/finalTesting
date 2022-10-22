package UsesCases.Queries.Cargo.GetAll;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GetAllCargoHandler_Test {

	ICargoRepository cargoRepository = Mockito.mock(ICargoRepository.class);

	@Test
	public void HandleCorrectly() throws Exception {
		Cargo a = new Cargo("Nombre cargo");
		List<Cargo> list = new ArrayList<Cargo>();
		list.add(a);
		when(cargoRepository.GetAll()).thenReturn(list);
		GetAllCargoHandler handler = new GetAllCargoHandler(cargoRepository);
		GetAllCargoQuery query = new GetAllCargoQuery();
		Assert.assertEquals(list.size(), handler.handle(query).size());
		verify(cargoRepository).GetAll();
	}
}
