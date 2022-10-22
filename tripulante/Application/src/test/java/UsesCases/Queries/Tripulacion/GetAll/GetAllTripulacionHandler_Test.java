package UsesCases.Queries.Tripulacion.GetAll;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Model.Tripulacion.Tripulacion;
import Repositories.ITripulacionRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GetAllTripulacionHandler_Test {

	ITripulacionRepository tripulacionRepository = Mockito.mock(
		ITripulacionRepository.class
	);

	@Test
	public void HandleCorrectly() throws Exception {
		Tripulacion a = new Tripulacion("Nombre tripulacion");
		List<Tripulacion> list = new ArrayList<Tripulacion>();
		list.add(a);
		when(tripulacionRepository.GetAll()).thenReturn(list);
		GetAllTripulacionHandler handler = new GetAllTripulacionHandler(
			tripulacionRepository
		);
		GetAllTripulacionQuery query = new GetAllTripulacionQuery();
		Assert.assertEquals(list.size(), handler.handle(query).size());
		verify(tripulacionRepository).GetAll();
	}
}
