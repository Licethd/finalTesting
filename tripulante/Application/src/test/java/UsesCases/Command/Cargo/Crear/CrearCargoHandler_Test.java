package UsesCases.Command.Cargo.Crear;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.Cargo.CargoDto;
import Factories.ICargoFactory;
import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import Repositories.IUnitOfWork;
import UsesCases.Command.Cargo.Crear.CrearCargoCommand;
import UsesCases.Command.Cargo.Crear.CrearCargoHandler;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CrearCargoHandler_Test {

	ICargoFactory cargoFactory = Mockito.mock(ICargoFactory.class);
	ICargoRepository cargoRepository = Mockito.mock(ICargoRepository.class);
	IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

	@Before
	public void setUp() {}

	@Test
	public void HandleCorrectly() throws Exception {
		String descripcion = "Administracion";

		Cargo entity = new Cargo(descripcion);
		when(cargoFactory.Create(descripcion)).thenReturn(entity);

		CrearCargoHandler handler = new CrearCargoHandler(
			cargoFactory,
			cargoRepository,
			_unitOfWork
		);

		CargoDto dto = new CargoDto();
		dto.Descripcion = descripcion;

		CrearCargoCommand command = new CrearCargoCommand(dto);
		UUID resp = handler.handle(command);

		// verify(marcaRepository).Create(resp);
		verify(_unitOfWork).commit();
		Assert.assertNotNull(resp);
	}
}
