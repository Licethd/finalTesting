package Repository;

import Context.IWriteDbContext;
import Fourteam.db.DbSet;
import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import java.util.List;
import java.util.UUID;

public class CargoRepository implements ICargoRepository {

	private DbSet<Cargo> _cargo;

	public CargoRepository(IWriteDbContext database) {
		_cargo = database.Cargo;
	}

	@Override
	public Cargo FindByKey(UUID key) throws Exception {
		return _cargo.Single(obj -> obj.key.toString().equals(key.toString()));
	}

	@Override
	public void Create(Cargo obj) throws Exception {
		_cargo.Add(obj);
	}

	@Override
	public List<Cargo> GetAll() throws Exception {
		return _cargo.All();
	}

	@Override
	public Cargo Delete(Cargo obj) throws Exception {
		_cargo.Delete((it -> it.key.equals(obj.key)));
		return obj;
	}

	@Override
	public Cargo Update(Cargo obj) throws Exception {
		_cargo.Update(obj, (it -> it.key.equals(obj.key)));
		return obj;
	}
}
