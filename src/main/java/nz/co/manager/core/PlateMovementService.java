package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.PlateMovement;
import nz.co.manager.jdbi.PlateMovementDAO;

@Service
public class PlateMovementService extends CRUDService<PlateMovement> {

	@Inject
	public PlateMovementService(PlateMovementDAO dao) {
		super(dao);
	}
}
