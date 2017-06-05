package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.MountainPlacement;
import nz.co.manager.jdbi.MountainPlacementDAO;

@Service
public class MountainPlacementService extends CRUDService<MountainPlacement> {

	@Inject
	public MountainPlacementService(final MountainPlacementDAO dao) {
		super(dao);
	}
}
