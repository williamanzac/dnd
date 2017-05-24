package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.VolcanicActivity;
import nz.co.manager.jdbi.VolcanicActivityDAO;

@Service
public class VolcanicActivityService extends CRUDService<VolcanicActivity> {

	@Inject
	public VolcanicActivityService(VolcanicActivityDAO dao) {
		super(dao);
	}
}
