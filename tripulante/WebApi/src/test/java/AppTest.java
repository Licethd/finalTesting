import org.junit.Assert;
import org.junit.Test;

public class AppTest {

	@Test
	public void constructor() {
		Assert.assertNotNull(new App());
		Assert.assertNotNull(new Infraestructure());
		Assert.assertNotNull(new WebApi());
	}
}
