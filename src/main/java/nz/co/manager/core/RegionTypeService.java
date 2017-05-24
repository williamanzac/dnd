package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.RegionType;
import nz.co.manager.jdbi.RegionTypeDAO;

@Service
public class RegionTypeService extends CRUDService<RegionType> {

	@Inject
	public RegionTypeService(RegionTypeDAO dao) {
		super(dao);
	}
}
