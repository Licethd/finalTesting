package UsesCases.Queries.Cargo.GetByKey;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class GetCargoByKeyQuery_Test {

	@Test
	public void dataValid() {
		UUID key = UUID.randomUUID();
		GetCargoByKeyQuery command = new GetCargoByKeyQuery(key);
		Assert.assertNotNull(command);
	}
}
