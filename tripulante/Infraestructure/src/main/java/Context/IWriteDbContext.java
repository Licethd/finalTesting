package Context;

import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import Fourteam.db.DbContext;
import Fourteam.db.DbSet;
import Fourteam.db.Exception.DataBaseException;

public abstract class IWriteDbContext extends DbContext {

	public IWriteDbContext(Class dbContextClass) throws DataBaseException {
		super(dbContextClass);
	}

	public DbSet<Tripulante> Tripulante;
	public DbSet<Cargo> Cargo;
	public DbSet<Tripulacion> Tripulacion;
}
