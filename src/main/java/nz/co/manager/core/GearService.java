package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.Gear;
import nz.co.manager.jdbi.GearDAO;

@Service
public class GearService extends CRUDService<Gear> {

	@Inject
	public GearService(final GearDAO gearDAO) {
		super(gearDAO);
	}
}
