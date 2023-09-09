import Controllers.CargoController;
import Controllers.TripulacionController_Test;
import Controllers.TripulanteController;
import Fourteam.config.Config;
import Fourteam.http.Rest;

public class WebApi {

	// prueba dfdfdffsdfsdfasdasdasdasdsfsfd

	public static void AddControllers() {
		Rest.addController(TripulanteController.class);
		Rest.addController(CargoController.class);
		Rest.addController(TripulacionController_Test.class);

		Rest.start(Integer.parseInt(Config.getProperty("http.port")));
		Rest.createSwagger();
	}
}
