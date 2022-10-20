package UsesCases.DomainEventHandler.Tripulacion;

import Event.TripulacionChange;
import Event.TripulacionRegistrado;
import Fourteam.massTransit.IPublishEndpoint;
import Fourteam.mediator.NotificationHandler;
import Model.Tripulacion.Tripulacion;
import Repositories.ITripulacionRepository;
import core.ConfirmedDomainEvent;
import java.util.ArrayList;
import java.util.List;

public class PublishIntegrationEventWhenTripulacionCreadoHandler
	implements
		NotificationHandler<ConfirmedDomainEvent<TripulacionRegistrado>> {

	private IPublishEndpoint publishEndpoint;
	private ITripulacionRepository _tripulacionRepository;

	public PublishIntegrationEventWhenTripulacionCreadoHandler(
		IPublishEndpoint publishEndpoint,
		ITripulacionRepository tripulacionRepository
	) {
		this.publishEndpoint = publishEndpoint;
		this._tripulacionRepository = tripulacionRepository;
	}

	@Override
	public void handle(ConfirmedDomainEvent<TripulacionRegistrado> event) {
		try {
			TripulacionRegistrado tripulacionChange = (TripulacionRegistrado) event.DomainEvent;
			Tripulacion tripulacion = _tripulacionRepository.FindByKey(
				tripulacionChange.KeyTripulacion
			);
			IntegrationEvents.TripulacionCreado evento = new IntegrationEvents.TripulacionCreado();
			evento.keyTripulacion = tripulacion.key;
			evento.estado = tripulacion.getEstado() + "";
			evento.descripcion = tripulacion.getDescripcion();
			// evento.tripulantes = new ArrayList<TripulanteDto>();
			this.publishEndpoint.Publish(evento);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
