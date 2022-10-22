package UsesCases.Command.Cargo.Editar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Dto.Cargo.CargoDto;
import Factories.ICargoFactory;
import Fourteam.http.Exception.HttpException;
import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import Repositories.IUnitOfWork;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class EditarCargoHandler_Test {

	ICargoFactory cargoFactory = Mockito.mock(ICargoFactory.class);
	ICargoRepository cargoRepository = Mockito.mock(ICargoRepository.class);
	IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

	@Before
	public void setUp() {}

	@Test
	public void HandleCorrectly() throws Exception {
		UUID key = UUID.randomUUID();
		String descripcion = "Piloto";

		Cargo entity = new Cargo(descripcion);
		entity.key = key;
		when(cargoFactory.Create(descripcion)).thenReturn(entity);
		when(cargoRepository.FindByKey(any())).thenReturn(entity);

		EditarCargoHandler handler = new EditarCargoHandler(
			cargoFactory,
			cargoRepository,
			_unitOfWork
		);

		CargoDto dto = new CargoDto();
		dto.key = key;
		dto.Descripcion = descripcion;

		EditarCargoCommand command = new EditarCargoCommand(dto.key);
		command.cargoDto.Descripcion = descripcion;
		CargoDto resp = handler.handle(command);

		Assert.assertEquals(descripcion, resp.Descripcion);
	}

	@Test
	public void HandleFailed() throws Exception {
		when(cargoRepository.FindByKey(any())).thenReturn(null);
		EditarCargoHandler handler = new EditarCargoHandler(
			cargoFactory,
			cargoRepository,
			_unitOfWork
		);
		CargoDto dto = new CargoDto();
		dto.Descripcion = "Asistente";
		dto.key = UUID.randomUUID();
		EditarCargoCommand command = new EditarCargoCommand(dto.key);
		try {
			handler.handle(command);
		} catch (HttpException e) {
			Assert.assertEquals(400, e.getCode());
		}
	}
}
