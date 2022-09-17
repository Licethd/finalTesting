package UsesCases.DomainEventHandler.Tripulacion;

import Event.TripulacionRegistrado;
import core.ConfirmedDomainEvent;
import Fourteam.massTransit.IPublishEndpoint;
import Fourteam.mediator.Notification;
import Fourteam.mediator.NotificationHandler;

public class PublishIntegrationEventWhenTripulacionCreadoHandler
  implements NotificationHandler<ConfirmedDomainEvent<TripulacionRegistrado>> {

  private IPublishEndpoint publishEndpoint;

  public PublishIntegrationEventWhenTripulacionCreadoHandler(IPublishEndpoint publishEndpoint) {
    this.publishEndpoint = publishEndpoint;
  }

  @Override
  public void handle(Notification notification) {
    ConfirmedDomainEvent event = (ConfirmedDomainEvent) notification;
	try{
		TripulacionRegistrado tripulacion = (TripulacionRegistrado) event.DomainEvent;
		IntegrationEvents.TripulacionCreado evento = new IntegrationEvents.TripulacionCreado();
		evento.setKeyTripulacion(tripulacion.getKey());
		evento.setDescripcion(tripulacion.getNombre());
		this.publishEndpoint.Publish(evento);
	}catch(Exception e){

	}

  }
}
