package Repository;

import Context.IWriteDbContext;
import Fourteam.db.DbSet;
import Model.Tripulante.Tripulante;
import Repositories.ITripulanteRepository;
import java.util.List;
import java.util.UUID;

public class TripulanteRepository implements ITripulanteRepository {

	private DbSet<Tripulante> _tripulantes;

	public TripulanteRepository(IWriteDbContext database) {
		_tripulantes = database.Tripulante;
	}

	@Override
	public Tripulante FindByKey(UUID key) throws Exception {
		return _tripulantes.Single(obj ->
			obj.key.toString().equals(key.toString())
		);
	}

	@Override
	public void Create(Tripulante obj) throws Exception {
		_tripulantes.Add(obj);
	}

	@Override
	public List<Tripulante> GetAll() throws Exception {
		return _tripulantes.All();
	}

	@Override
	public Tripulante Delete(Tripulante obj) throws Exception {
		_tripulantes.Delete((it -> it.key.equals(obj.key)));
		return obj;
	}

	@Override
	public Tripulante Update(Tripulante obj) throws Exception {
		_tripulantes.Update(obj, (it -> it.key.equals(obj.key)));
		return obj;
	}
}
