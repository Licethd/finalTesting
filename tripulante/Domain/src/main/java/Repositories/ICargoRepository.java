package Repositories;

import Model.Tripulante.Cargo;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface ICargoRepository extends IRepository<Cargo, UUID> {
	public List<Cargo> GetAll() throws Exception;

	public Cargo Delete(Cargo cargo) throws Exception;

	public Cargo Update(Cargo cargo) throws Exception;
}
