package UsesCases.Command.Tripulante.Crear;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.Cargo.CargoDto;
import Dto.Tripulacion.TripulacionDto;
import Dto.Tripulante.TripulanteDto;
import Factories.ICargoFactory;
import Factories.ITripulacionFactory;
import Factories.ITripulanteFactory;
import Fourteam.http.Exception.HttpException;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import Repositories.ICargoRepository;
import Repositories.ITripulacionRepository;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import UsesCases.Command.Cargo.Crear.CrearCargoCommand;
import UsesCases.Command.Cargo.Crear.CrearCargoHandler;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CrearTripulanteHandler_Test {

	ICargoRepository cargoRepository = Mockito.mock(ICargoRepository.class);
	ITripulanteFactory tripulanteFactory = Mockito.mock(
		ITripulanteFactory.class
	);
	ITripulanteRepository tripulanteRepository = Mockito.mock(
		ITripulanteRepository.class
	);
	IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

	@Before
	public void setUp() {}

	@Test
	public void HandleCorrectly() throws Exception {
		String nombre = "Julio";
		String apellido = "Morales";
		String emailAddress = "juanito@gmail.com";
		String estado = "1";
		String tipo = "AIRE";
		Double horasVuelo = 1522.0;
		Double nroMillas = 1522.0;
		UUID keyCargo = UUID.randomUUID();

		Tripulante entity = new Tripulante(
			"Julio",
			"Flores",
			"julio@gmail.com",
			"AIRE",
			1522.0,
			453.0,
			keyCargo
		);
		when(
			tripulanteFactory.Create(
				any(),
				any(),
				any(),
				any(),
				any(),
				any(),
				any(),
				any()
			)
		)
			.thenReturn(entity);

		Cargo m = new Cargo("Piloto");
		when(cargoRepository.FindByKey(any())).thenReturn(m);

		CrearTripulanteHandler handler = new CrearTripulanteHandler(
			tripulanteFactory,
			tripulanteRepository,
			cargoRepository,
			_unitOfWork
		);

		TripulanteDto dto = new TripulanteDto();
		dto.Nombre = nombre;
		dto.Apellido = apellido;
		dto.EmailAddress = emailAddress;
		dto.Estado = estado;
		dto.Tipo = tipo;
		dto.HorasVuelo = horasVuelo;
		dto.NroMillas = nroMillas;
		dto.KeyCargo = keyCargo;

		CrearTripulanteCommand command = new CrearTripulanteCommand(dto);
		UUID resp = handler.handle(command); // se tira

		verify(_unitOfWork).commit();
		Assert.assertNotNull(resp);
	}

	@Test
	public void HandleIncorrectly() throws Exception {
		String nombre = "Julio";
		String apellido = "Morales";
		String emailAddress = "juanito@gmail.com";
		String estado = "1";
		String tipo = "AIRE";
		Double horasVuelo = 1522.0;
		Double nroMillas = 1522.0;
		UUID keyCargo = UUID.randomUUID();

		Tripulante entity = new Tripulante(
			"Julio",
			"Flores",
			"julio@gmail.com",
			"AIRE",
			1522.0,
			453.0,
			keyCargo
		);
		when(
			tripulanteFactory.Create(
				any(),
				any(),
				any(),
				any(),
				any(),
				any(),
				any(),
				any()
			)
		)
			.thenReturn(entity);

		Cargo m = new Cargo("Piloto");
		when(cargoRepository.FindByKey(any())).thenReturn(null);

		CrearTripulanteHandler handler = new CrearTripulanteHandler(
			tripulanteFactory,
			tripulanteRepository,
			cargoRepository,
			_unitOfWork
		);

		TripulanteDto dto = new TripulanteDto();
		dto.Nombre = nombre;
		dto.Apellido = apellido;
		dto.EmailAddress = emailAddress;
		dto.Estado = estado;
		dto.Tipo = tipo;
		dto.HorasVuelo = horasVuelo;
		dto.NroMillas = nroMillas;
		dto.KeyCargo = keyCargo;

		CrearTripulanteCommand command = new CrearTripulanteCommand(dto);
		try {
			handler.handle(command);
		} catch (HttpException e) {
			Assert.assertEquals(400, e.getCode());
		}
	}
}
