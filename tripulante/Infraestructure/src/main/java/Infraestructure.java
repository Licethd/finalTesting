
import Repositories.*;
import Fourteam.config.Config;
import Fourteam.extensions.IServiceCollection;
import Context.IWriteDbContext;
import Repository.*;
import UsesCases.Consumers.VueloCreadoConsumer;

public class Infraestructure {
	public static void AddInfraestructure() {

		IServiceCollection.AddMediator();

		IServiceCollection.AddScoped(IWriteDbContext.class, Context.MongoDB.WriteDbContext.class);
		IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
		IServiceCollection.AddScoped(ITripulanteRepository.class, TripulanteRepository.class);
		IServiceCollection.AddScoped(ICargoRepository.class, CargoRepository.class);
		IServiceCollection.AddScoped(ITripulacionRepository.class, TripulacionRepository.class);
		Application.AddApplication();
		AddRabbitMq();
	}

	private static void AddRabbitMq() {
		IServiceCollection.AddMassTransit(config -> {

			config.AddConsumer(VueloCreadoConsumer.class);
			config.UsingRabbitMq((context, cfg) -> {
				cfg.Host = Config.getProperty("rabit.host");
				cfg.User = Config.getProperty("rabit.user");
				cfg.Password = Config.getProperty("rabit.pass");
			});
		});
	}
}
