package Repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Context.IWriteDbContext;
import Fourteam.db.DbSet;
import Fourteam.db.Exception.DataBaseException;
import Model.Tripulante.Cargo;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class CargoRepository_Test {

	IWriteDbContext _database = Mockito.mock(IWriteDbContext.class);
	DbSet<Cargo> _cargos = Mockito.mock(DbSet.class);

	@Before
	public void setUp() {
		_database.Cargo = _cargos;
	}

	@Test
	public void constructor_accept() {
		CargoRepository repository = new CargoRepository(_database);
		Assert.assertNotNull(repository);
	}

	@Test
	public void FindByKey_accept() throws Exception {
		// Mockito.verify(_cargos).Single(obj -> obj.key.equals(UUID.randomUUID()));
		Cargo a = new Cargo();
		when(_cargos.Single(any())).thenReturn(a);
		CargoRepository repository = new CargoRepository(_database);
		// ArgumentCaptor<Cargo> captor = ArgumentCaptor.forClass(Cargo.class);
		repository.FindByKey(UUID.randomUUID());
		Assert.assertNotNull(repository);
	}

	@Test
	public void GetAll_accept() throws Exception {
		CargoRepository repository = new CargoRepository(_database);
		repository.GetAll();
		Assert.assertNotNull(repository);
	}

	@Test
	public void Create_accept() throws Exception {
		CargoRepository repository = new CargoRepository(_database);
		repository.Create(new Cargo());
		Assert.assertNotNull(repository);
	}

	@Test
	public void Delete_accept() throws Exception {
		CargoRepository repository = new CargoRepository(_database);
		repository.Delete(new Cargo());
		Assert.assertNotNull(repository);
	}

	@Test
	public void Update_accept() throws Exception {
		CargoRepository repository = new CargoRepository(_database);
		repository.Update(new Cargo());
		Assert.assertNotNull(repository);
	}
}
