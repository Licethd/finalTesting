package UsesCases.Command.Cargo.Eliminar;

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

public class EliminarCargoHandler_Test {

	ICargoFactory cargoFactory = Mockito.mock(ICargoFactory.class);
	ICargoRepository cargoRepository = Mockito.mock(ICargoRepository.class);
	IUnitOfWork _unitOfWork = Mockito.mock(IUnitOfWork.class);

	@Before
	public void setUp() {}

	@Test
	public void HandleCorrectly() throws Exception {
		UUID key = UUID.randomUUID();
		String descripcion = "Cargo test1";

		Cargo entity = new Cargo(descripcion);
		entity.key = key;
		when(cargoRepository.Delete(any())).thenReturn(entity);
		when(cargoRepository.FindByKey(any())).thenReturn(entity);

		EliminarCargoHandler handler = new EliminarCargoHandler(
			cargoFactory,
			cargoRepository,
			_unitOfWork
		);

		CargoDto dto = new CargoDto();
		dto.key = key;
		dto.Descripcion = descripcion;

		EliminarCargoCommand command = new EliminarCargoCommand(dto.key);
		command.cargo.Descripcion = descripcion;
		UUID resp = handler.handle(command);

		Assert.assertEquals(dto.key, resp);
	}

	@Test
	public void HandleFailed() throws Exception {
		when(cargoRepository.FindByKey(any())).thenReturn(null);
		EliminarCargoHandler handler = new EliminarCargoHandler(
			cargoFactory,
			cargoRepository,
			_unitOfWork
		);
		CargoDto dto = new CargoDto();
		dto.Descripcion = "ABC";
		dto.key = UUID.randomUUID();
		EliminarCargoCommand command = new EliminarCargoCommand(dto.key);
		try {
			handler.handle(command);
		} catch (HttpException e) {
			Assert.assertEquals(400, e.getCode());
		}
	}
}
