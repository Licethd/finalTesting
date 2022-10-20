package UsesCases.Consumers;

import Factories.ITripulacionFactory;
import Fourteam.massTransit.IConsumer;
import Fourteam.mediator.IMediator;
import Model.Tripulacion.Tripulacion;
import Repositories.ITripulacionRepository;
import UsesCases.Command.Tripulacion.Editar.EditarTripulacionCommand;
import core.IntegrationEvent;

public class VueloCreadoConsumer
	extends IConsumer<IntegrationEvents.VueloCreado> {

	private ITripulacionFactory _tripulacionFactory;
	private ITripulacionRepository _tripulacionRepository;

	public VueloCreadoConsumer(
		IMediator mediator,
		ITripulacionRepository tripulacionRepository
	) {
		System.out.println("Entro al constructor del consumer");
		this._tripulacionRepository = tripulacionRepository;
	}

	@Override
	public void Consume(IntegrationEvents.VueloCreado object) {
		try {
			Tripulacion tripulacion = _tripulacionRepository.FindByKey(
				object.keyTripulacion
			);
			tripulacion.setEstado(2);
			_tripulacionRepository.Update(tripulacion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// _tripulacionRepository.Update(tripulacion)
		System.out.println("Entro al consumido " + object.keyTripulacion);
	}
}
