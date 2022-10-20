package Repositories;

import Model.Tripulante.Tripulante;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface ITripulanteRepository extends IRepository<Tripulante, UUID> {
	public List<Tripulante> GetAll() throws Exception;

	public Tripulante Delete(Tripulante tripulante) throws Exception;

	public Tripulante Update(Tripulante tripulante) throws Exception;
}
