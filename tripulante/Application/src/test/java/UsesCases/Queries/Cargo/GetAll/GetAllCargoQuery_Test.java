package UsesCases.Queries.Cargo.GetAll;

import org.junit.Assert;
import org.junit.Test;

public class GetAllCargoQuery_Test {

	@Test
	public void dataValid() {
		GetAllCargoQuery command = new GetAllCargoQuery();
		Assert.assertNotNull(command);
	}

	@Test
	public void constructorIsPrivate() {
		Assert.assertTrue(
			GetAllCargoQuery.class.getConstructors()[0].canAccess(null)
		);
	}
}
