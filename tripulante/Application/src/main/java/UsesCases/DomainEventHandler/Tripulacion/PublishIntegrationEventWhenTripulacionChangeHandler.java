package UsesCases.DomainEventHandler.Tripulacion;

import java.util.List;

import java.util.ArrayList;

import Event.TripulacionChange;
import core.ConfirmedDomainEvent;
import Fourteam.massTransit.IPublishEndpoint;
import Fourteam.mediator.Notification;
import Fourteam.mediator.NotificationHandler;
import Model.Tripulacion.Tripulacion;
import Repositories.ITripulacionRepository;

public class PublishIntegrationEventWhenTripulacionChangeHandler
  implements NotificationHandler<ConfirmedDomainEvent<TripulacionChange>> {

  private IPublishEndpoint publishEndpoint;
  private ITripulacionRepository _tripulacionRepository;

  public PublishIntegrationEventWhenTripulacionChangeHandler(IPublishEndpoint publishEndpoint,ITripulacionRepository tripulacionRepository) {
    this.publishEndpoint = publishEndpoint;
	this._tripulacionRepository = tripulacionRepository;
  }

  @Override
  public void handle(Notification notification) {
    ConfirmedDomainEvent event = (ConfirmedDomainEvent) notification;
    TripulacionChange tripulacionChange = (TripulacionChange) event.DomainEvent;


	try {
		Tripulacion tripulacion = _tripulacionRepository.FindByKey(tripulacionChange.Key);
		IntegrationEvents.TripulacionChange evento = new IntegrationEvents.TripulacionChange();
		evento.Key = tripulacion.key;
		evento.descripcion = tripulacion.getDescripcion();
		List<IntegrationEvents.dto.TripulanteDto> arrTripulantes = new ArrayList<>();
		tripulacion.Tripulantes.iterator().forEachRemaining(tripulante -> {
		  IntegrationEvents.dto.TripulanteDto tripulanteDto = new IntegrationEvents.dto.TripulanteDto();
		  tripulanteDto.key = tripulante.key;
		  tripulanteDto.nombre = tripulante.getNombre();
		  tripulanteDto.apellido = tripulante.getApellido();
		  tripulanteDto.tipo = tripulante.getTipo();



		  arrTripulantes.add(tripulanteDto);
		});
		evento.tripulantes = arrTripulantes;
		this.publishEndpoint.Publish(evento);
	  } catch (Exception e) {
		e.printStackTrace();
	  }


    // IntegrationEvents.TripulacionChange evento = new IntegrationEvents.TripulacionChange();
    // evento.setKeyTripulacion(tripulacion.getKey());
    // evento.setDescripcion(tripulacion.getNombre());
    // this.publishEndpoint.Publish(evento);
  }
}
