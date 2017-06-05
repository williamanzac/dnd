package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.DisplayType;
import nz.co.manager.jdbi.DisplayTypeDAO;

@Service
public class DisplayTypeService extends CRUDService<DisplayType> {

	@Inject
	public DisplayTypeService(final DisplayTypeDAO dao) {
		super(dao);
	}
}
