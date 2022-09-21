package UsesCases.DomainEventHandler.Tripulacion;

import java.util.List;

import java.util.ArrayList;

import Event.TripulacionChange;
import core.ConfirmedDomainEvent;
import Fourteam.massTransit.IPublishEndpoint;
import Fourteam.mediator.NotificationHandler;
import Model.Tripulacion.Tripulacion;
import Repositories.ITripulacionRepository;

public class PublishIntegrationEventWhenTripulacionChangeHandler
		implements NotificationHandler<ConfirmedDomainEvent<TripulacionChange>> {

	private IPublishEndpoint publishEndpoint;
	private ITripulacionRepository _tripulacionRepository;

	public PublishIntegrationEventWhenTripulacionChangeHandler(IPublishEndpoint publishEndpoint,
			ITripulacionRepository tripulacionRepository) {
		this.publishEndpoint = publishEndpoint;
		this._tripulacionRepository = tripulacionRepository;
	}

	@Override
	public void handle(ConfirmedDomainEvent<TripulacionChange> event) {

		try {
			TripulacionChange tripulacionChange = (TripulacionChange) event.DomainEvent;
			Tripulacion tripulacion = _tripulacionRepository.FindByKey(tripulacionChange.KeyTripulacion);
			IntegrationEvents.TripulacionChange evento = new IntegrationEvents.TripulacionChange();
			evento.keyTripulacion = tripulacion.key;
			evento.estado = tripulacion.getEstado() + "";
			evento.descripcion = tripulacion.getDescripcion();
			List<IntegrationEvents.dto.TripulanteDto> arrTripulantes = new ArrayList<>();
			tripulacion.Tripulantes.iterator().forEachRemaining(tripulante -> {
				IntegrationEvents.dto.TripulanteDto tripulanteDto = new IntegrationEvents.dto.TripulanteDto();
				tripulanteDto.key = tripulante.key;
				tripulanteDto.estado = tripulante.getEstado() + "";
				tripulanteDto.nombre = tripulante.getNombre();
				tripulanteDto.apellido = tripulante.getApellido();
				tripulanteDto.tipo = tripulante.getTipo();

				tripulanteDto.setCargo(tripulante.getCargo().getDescripcion());
				arrTripulantes.add(tripulanteDto);
			});
			evento.tripulantes = arrTripulantes;
			this.publishEndpoint.Publish(evento);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
