package Model.Tripulante.ValueObjects;

// import core.BussinessRule;
import core.ValueObject;

public class HorasVuelo extends ValueObject {

	public Double Value;

	public HorasVuelo(Double value) {
		if (value <= 0) {
			// try {
			//     throw new BussinessRuleValidateExeption("La cantidad no puede ser negativa o cero");
			// } catch (BussinessRuleValidateExeption e) {
			//      e.printStackTrace();
			// }
		}
		Value = value;
	}
}
