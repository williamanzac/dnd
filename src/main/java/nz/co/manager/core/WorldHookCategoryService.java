package nz.co.manager.core;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.WorldHook;
import nz.co.manager.api.WorldHookCategory;
import nz.co.manager.jdbi.WorldHookCategoryDAO;
import nz.co.manager.jdbi.WorldHookDAO;

@Service
public class WorldHookCategoryService extends CRUDService<WorldHookCategory> {

	private final WorldHookDAO worldHookDAO;

	@Inject
	public WorldHookCategoryService(final WorldHookDAO worldHookDAO, final WorldHookCategoryDAO worldHookCategoryDAO) {
		super(worldHookCategoryDAO);
		this.worldHookDAO = worldHookDAO;
	}

	@Override
	public WorldHookCategory create(final WorldHookCategory entity) {
		if (entity.getWorldHooks() != null) {
			for (final WorldHook hook : entity.getWorldHooks()) {
				worldHookDAO.update(hook);
			}
		}
		super.create(entity);
		return entity;
	}

	@Override
	public WorldHookCategory update(final WorldHookCategory entity) {
		if (entity.getWorldHooks() != null) {
			for (final WorldHook hook : entity.getWorldHooks()) {
				worldHookDAO.update(hook);
			}
		}
		super.update(entity);
		return entity;
	}
}
