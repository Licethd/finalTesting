package UsesCases.Queries.Tripulante.GetByKey;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class GetTripulanteByKeyQuery_Test {

	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		GetTripulanteByKeyQuery command = new GetTripulanteByKeyQuery(key);
		Assert.assertNotNull(command);
	}
}
