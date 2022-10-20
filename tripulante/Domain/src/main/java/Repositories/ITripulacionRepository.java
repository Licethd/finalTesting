package Repositories;

import Model.Tripulacion.Tripulacion;
// import Domain.Model.Cargo.Aeronave;
import Model.Tripulante.Cargo;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface ITripulacionRepository extends IRepository<Tripulacion, UUID> {
	public List<Tripulacion> GetAll() throws Exception;

	public Tripulacion Delete(Tripulacion tripulacion) throws Exception;

	public Tripulacion Update(Tripulacion tripulacion) throws Exception;

	public Tripulacion FindByTripulante(Tripulacion tripulacion, UUID key)
		throws Exception;
}
