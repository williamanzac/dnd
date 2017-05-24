package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.MountainProperty;
import nz.co.manager.jdbi.MountainPropertyDAO;

@Service
public class MountainPropertyService extends CRUDService<MountainProperty> {

	@Inject
	public MountainPropertyService(final MountainPropertyDAO dao) {
		super(dao);
	}
}
