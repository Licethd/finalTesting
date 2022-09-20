package UsesCases.Consumers;

import core.IntegrationEvent;
import Fourteam.massTransit.IConsumer;
import Fourteam.mediator.IMediator;

public class VueloCreadoConsumer extends IConsumer<IntegrationEvents.VueloCreado> {

  public VueloCreadoConsumer(IMediator mediator) {
    System.out.println("Entro al constructor del consumer");
  }

  @Override
  public void Consume(IntegrationEvents.VueloCreado object) {
    // TODO Auto-generated method stub
    System.out.println("Entro al consumido " + object.keyTripulacion);

  }
}
