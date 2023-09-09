package Repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Context.IWriteDbContext;
import Fourteam.db.DbSet;
import Fourteam.db.IDbSet.BooleanFunction;
import Fourteam.db.Exception.DataBaseException;
import Model.Tripulante.Tripulante;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class TripulanteRepository_Test {

	IWriteDbContext _database = Mockito.mock(IWriteDbContext.class);
	DbSet<Tripulante> _tripulante = Mockito.mock(DbSet.class);

	@Before
	public void setUp() {
		_database.Tripulante = _tripulante;
	}

	@Test
	public void constructor_accept() {
		TripulanteRepository repository = new TripulanteRepository(_database);
		Assert.assertNotNull(repository);
	}

	@Test
	public void probando_lambda_by_key() {
		TripulanteRepository repository = new TripulanteRepository(_database);
		Tripulante a = new Tripulante();
		a.key = UUID.randomUUID();
		BooleanFunction<Tripulante> equalkey = repository.equalKey(a.key);
		equalkey.run(a);
	}

	@Test
	public void FindByKey_accept() throws Exception {
		// Mockito.verify(_tripulante).Single(obj -> obj.key.equals(UUID.randomUUID()));
		Tripulante a = new Tripulante();
		when(_tripulante.Single(any())).thenReturn(a);
		TripulanteRepository repository = new TripulanteRepository(_database);
		// ArgumentCaptor<Tripulante> captor =
		// ArgumentCaptor.forClass(Tripulante.class);
		repository.FindByKey(UUID.randomUUID());
		Assert.assertNotNull(repository);
	}

	@Test
	public void GetAll_accept() throws Exception {
		TripulanteRepository repository = new TripulanteRepository(_database);
		repository.GetAll();
		Assert.assertNotNull(repository);
	}

	@Test
	public void Create_accept() throws Exception {
		TripulanteRepository repository = new TripulanteRepository(_database);
		repository.Create(new Tripulante());
		Assert.assertNotNull(repository);
	}

	@Test
	public void Delete_accept() throws Exception {
		TripulanteRepository repository = new TripulanteRepository(_database);
		repository.Delete(new Tripulante());
		Assert.assertNotNull(repository);
	}

	@Test
	public void Update_accept() throws Exception {
		TripulanteRepository repository = new TripulanteRepository(_database);
		repository.Update(new Tripulante());
		Assert.assertNotNull(repository);
	}
}
