package UsesCases.DomainEventHandler.Tripulacion;

import Event.TripulacionChange;
import Fourteam.massTransit.IPublishEndpoint;
import Fourteam.mediator.NotificationHandler;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import Repositories.ITripulacionRepository;
import core.ConfirmedDomainEvent;
import java.util.ArrayList;
import java.util.List;

public class PublishIntegrationEventWhenTripulacionChangeHandler
	implements NotificationHandler<ConfirmedDomainEvent<TripulacionChange>> {

	private IPublishEndpoint publishEndpoint;
	private ITripulacionRepository _tripulacionRepository;
	private ICargoRepository _cargoRepository;

	public PublishIntegrationEventWhenTripulacionChangeHandler(
		IPublishEndpoint publishEndpoint,
		ITripulacionRepository tripulacionRepository,
		ICargoRepository cargoRepository
	) {
		this.publishEndpoint = publishEndpoint;
		this._tripulacionRepository = tripulacionRepository;
		this._cargoRepository = cargoRepository;
	}

	@Override
	public void handle(ConfirmedDomainEvent<TripulacionChange> event) {
		try {
			TripulacionChange tripulacionChange = (TripulacionChange) event.DomainEvent;
			Tripulacion tripulacion = _tripulacionRepository.FindByKey(
				tripulacionChange.KeyTripulacion
			);
			IntegrationEvents.TripulacionChange evento = new IntegrationEvents.TripulacionChange();
			evento.keyTripulacion = tripulacion.key;
			evento.estado = tripulacion.getEstado() + "";
			evento.descripcion = tripulacion.getDescripcion();
			List<IntegrationEvents.dto.TripulanteDto> arrTripulantes = new ArrayList<>();
			tripulacion.Tripulantes
				.iterator()
				.forEachRemaining(tripulante -> {
					IntegrationEvents.dto.TripulanteDto tripulanteDto = new IntegrationEvents.dto.TripulanteDto();
					tripulanteDto.key = tripulante.key;
					tripulanteDto.estado = tripulante.getEstado() + "";
					tripulanteDto.nombre = tripulante.getNombre();
					tripulanteDto.apellido = tripulante.getApellido();
					tripulanteDto.tipo = tripulante.getTipo();

					try {
						Cargo cargo = _cargoRepository.FindByKey(
							tripulante.getKeyCargo()
						);
						tripulanteDto.setCargo(cargo.getDescripcion());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					arrTripulantes.add(tripulanteDto);
				});
			evento.tripulantes = arrTripulantes;
			this.publishEndpoint.Publish(evento);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
