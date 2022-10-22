package UsesCases.Queries.Tripulante.GetAll;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Model.Tripulante.Tripulante;
import Repositories.ITripulanteRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GetAllTripulanteHandler_Test {

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
		List<Tripulante> list = new ArrayList<Tripulante>();
		list.add(a);
		when(tripulanteRepository.GetAll()).thenReturn(list);
		GetAllTripulanteHandler handler = new GetAllTripulanteHandler(
			tripulanteRepository
		);
		GetAllTripulanteQuery query = new GetAllTripulanteQuery();
		Assert.assertEquals(list.size(), handler.handle(query).size());
		verify(tripulanteRepository).GetAll();
	}
}
