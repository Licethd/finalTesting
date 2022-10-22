package UsesCases.Queries.Tripulacion.GetByKey;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class GetTripulacionByKeyQuery_Test {

	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		GetTripulacionByKeyQuery command = new GetTripulacionByKeyQuery(key);
		Assert.assertNotNull(command);
	}
}
