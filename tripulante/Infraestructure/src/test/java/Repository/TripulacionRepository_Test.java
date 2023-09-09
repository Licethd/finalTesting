package Repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Context.IWriteDbContext;
import Fourteam.db.DbSet;
import Fourteam.db.IDbSet.BooleanFunction;
import Fourteam.db.Exception.DataBaseException;
import Model.Tripulacion.Tripulacion;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class TripulacionRepository_Test {

	IWriteDbContext _database = Mockito.mock(IWriteDbContext.class);
	DbSet<Tripulacion> _tripulacion = Mockito.mock(DbSet.class);

	@Before
	public void setUp() {
		_database.Tripulacion = _tripulacion;
	}

	@Test
	public void constructor_accept() {
		TripulacionRepository repository = new TripulacionRepository(_database);
		Assert.assertNotNull(repository);
	}

	@Test
	public void probando_lambda_by_key() {
		Tripulacion a = new Tripulacion("Puma");
		// when(_marcas.Single(any())).then
		TripulacionRepository repository = new TripulacionRepository(_database);
		BooleanFunction<Tripulacion> equalkey = repository.equalKey(a.key);
		equalkey.run(a);
	}

	@Test
	public void FindByKey_accept() throws Exception {
		// Mockito.verify(_tripulacion).Single(obj ->
		// obj.key.equals(UUID.randomUUID()));
		Tripulacion a = new Tripulacion();
		when(_tripulacion.Single(any())).thenReturn(a);
		TripulacionRepository repository = new TripulacionRepository(_database);
		// ArgumentCaptor<Tripulacion> captor =
		// ArgumentCaptor.forClass(Tripulacion.class);
		repository.FindByKey(UUID.randomUUID());
		Assert.assertNotNull(repository);
	}

	@Test
	public void FindByTripulante_accept() throws Exception {
		// Mockito.verify(_tripulacion).Single(obj ->
		// obj.key.equals(UUID.randomUUID()));
		Tripulacion a = new Tripulacion();
		when(_tripulacion.Single(any())).thenReturn(a);
		TripulacionRepository repository = new TripulacionRepository(_database);
		// ArgumentCaptor<Tripulacion> captor =
		// ArgumentCaptor.forClass(Tripulacion.class);
		repository.FindByTripulante(a, UUID.randomUUID());
		Assert.assertNotNull(repository);
	}

	@Test
	public void GetAll_accept() throws Exception {
		TripulacionRepository repository = new TripulacionRepository(_database);
		repository.GetAll();
		Assert.assertNotNull(repository);
	}

	@Test
	public void Create_accept() throws Exception {
		TripulacionRepository repository = new TripulacionRepository(_database);
		repository.Create(new Tripulacion());
		Assert.assertNotNull(repository);
	}

	@Test
	public void Delete_accept() throws Exception {
		TripulacionRepository repository = new TripulacionRepository(_database);
		repository.Delete(new Tripulacion());
		Assert.assertNotNull(repository);
	}

	@Test
	public void Update_accept() throws Exception {
		TripulacionRepository repository = new TripulacionRepository(_database);
		repository.Update(new Tripulacion());
		Assert.assertNotNull(repository);
	}
}
