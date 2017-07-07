package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.DisplayType;
import nz.co.manager.api.Region;
import nz.co.manager.jdbi.DisplayTypeDAO;
import nz.co.manager.jdbi.RegionDAO;

@Service
public class DisplayTypeService extends CRUDService<DisplayType> {

	private final RegionDAO regionDAO;

	@Inject
	public DisplayTypeService(final DisplayTypeDAO dao, final RegionDAO regionDAO) {
		super(dao);
		this.regionDAO = regionDAO;
	}

	@Override
	public DisplayType create(final DisplayType entity) {
		if (entity.getRegions() != null) {
			for (final Region region : entity.getRegions()) {
				regionDAO.update(region);
			}
		}
		super.create(entity);
		return entity;
	}

	@Override
	public DisplayType update(final DisplayType entity) {
		if (entity.getRegions() != null) {
			for (final Region region : entity.getRegions()) {
				regionDAO.update(region);
			}
		}
		super.update(entity);
		return entity;
	}
}
