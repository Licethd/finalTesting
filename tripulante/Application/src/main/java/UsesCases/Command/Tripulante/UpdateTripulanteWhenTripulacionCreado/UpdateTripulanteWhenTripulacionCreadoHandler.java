package UsesCases.Command.Tripulante.UpdateTripulanteWhenTripulacionCreado;

import Event.TripulacionRegistrado;
import Repositories.ITripulanteRepository;
import core.ConfirmedDomainEvent;
import Fourteam.mediator.Notification;
import Fourteam.mediator.NotificationHandler;

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
