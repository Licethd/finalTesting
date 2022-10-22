package UsesCases.Queries.Tripulante.GetAll;

import org.junit.Assert;
import org.junit.Test;

public class GetAllTripulanteQuery_Test {

	@Test
	public void dataValid() {
		GetAllTripulanteQuery command = new GetAllTripulanteQuery();
		Assert.assertNotNull(command);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
			GetAllTripulanteQuery.class.getConstructors()[0].canAccess(null)
		);
	}
}
