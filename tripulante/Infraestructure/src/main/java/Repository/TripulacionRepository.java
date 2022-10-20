package Repository;

import Context.IWriteDbContext;
import Fourteam.db.DbSet;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import Repositories.ICargoRepository;
import Repositories.ITripulacionRepository;
import java.util.List;
import java.util.UUID;

public class TripulacionRepository implements ITripulacionRepository {

	private DbSet<Tripulacion> _tripulacion;

	public TripulacionRepository(IWriteDbContext database) {
		_tripulacion = database.Tripulacion;
	}

	@Override
	public Tripulacion FindByKey(UUID key) throws Exception {
		return _tripulacion.Single(obj ->
			obj.key.toString().equals(key.toString())
		);
	}

	@Override
	public Tripulacion FindByTripulante(Tripulacion object, UUID key)
		throws Exception {
		return _tripulacion.Single(obj ->
			obj.key.toString().equals(object.key.toString()) &&
			obj.Tripulantes
				.stream()
				.filter(tripulante ->
					tripulante.key.toString().equals(key.toString())
				)
				.findAny()
				.orElse(null) !=
			null
		);
	}

	@Override
	public void Create(Tripulacion obj) throws Exception {
		_tripulacion.Add(obj);
	}

	@Override
	public List<Tripulacion> GetAll() throws Exception {
		return _tripulacion.All();
	}

	@Override
	public Tripulacion Delete(Tripulacion obj) throws Exception {
		_tripulacion.Delete((it -> it.key.equals(obj.key)));
		return obj;
	}

	@Override
	public Tripulacion Update(Tripulacion obj) throws Exception {
		_tripulacion.Update(obj, (it -> it.key.equals(obj.key)));
		return obj;
	}
}
