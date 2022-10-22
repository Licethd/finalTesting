import static org.mockito.ArgumentMatchers.any;

import Fourteam.http.Rest;
import org.junit.Assert;
import org.junit.Test;

public class WebApiTest {

	@Test
	public void constructor() {
		Assert.assertNotNull(new WebApi());
		Rest.addController(any());
		Rest.start();
		Rest.createSwagger();
	}
}
