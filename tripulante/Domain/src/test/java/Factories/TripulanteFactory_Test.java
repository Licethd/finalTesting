package Factories;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class TripulanteFactory_Test {

	@Test
	public void constructor_accept() {
		Assert.assertNotNull(new TripulanteFactory());
	}

	@Test
	public void create_accept() {
		Assert.assertNotNull(
			new TripulanteFactory()
				.Create(
					anyString(),
					anyString(),
					anyString(),
					anyString(),
					anyString(),
					anyDouble(),
					anyDouble(),
					UUID.randomUUID()
				)
		);
	}
}
