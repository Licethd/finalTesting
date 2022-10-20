package UsesCases.Command.Tripulante.UpdateTripulanteWhenTripulacionCreado;

import Event.TripulacionRegistrado;
import Fourteam.mediator.Notification;
import Fourteam.mediator.NotificationHandler;
import Repositories.ITripulanteRepository;
import core.ConfirmedDomainEvent;

public class UpdateTripulanteWhenTripulacionCreadoHandler
	implements NotificationHandler<TripulacionRegistrado> {

	private ITripulanteRepository _tripulanteRepository;

	// private
	public UpdateTripulanteWhenTripulacionCreadoHandler(
		ITripulanteRepository tripulanteRepository
	) {
		this._tripulanteRepository = tripulanteRepository;
	}

	//   @Override
	//   public void handle(Notification notification) {
	//     System.out.println(notification);
	//   }

	@Override
	public void handle(TripulacionRegistrado event) {
		System.out.println(event);
	}
}
