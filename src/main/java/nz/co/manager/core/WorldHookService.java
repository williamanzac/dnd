package nz.co.manager.core;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.manager.api.WorldHook;
import nz.co.manager.api.WorldHookCategory;
import nz.co.manager.jdbi.WorldHookCategoryDAO;
import nz.co.manager.jdbi.WorldHookDAO;

@Service
public class WorldHookService {

	private final WorldHookDAO worldHookDAO;
	private final WorldHookCategoryDAO worldHookCategoryDAO;

	@Inject
	public WorldHookService(final WorldHookDAO worldHookDAO, final WorldHookCategoryDAO worldHookCategoryDAO) {
		this.worldHookDAO = worldHookDAO;
		this.worldHookCategoryDAO = worldHookCategoryDAO;
	}

	public List<WorldHook> generate(final int times) throws ServiceException {
		final List<WorldHookCategory> categories = listWorldHookCategories();
		final WorldHookCategory lastCategory = categories.get(categories.size() - 1);
		final DiceService diceService = new DiceService();
		final int max = lastCategory.getMax();
		final List<WorldHook> values = new ArrayList<>();
		final List<Integer> randomCats = diceService.roll(max, times);
		for (int i : randomCats) {
			for (WorldHookCategory cat : categories) {
				if (cat.getMin() <= i && cat.getMax() >= i) {
					final int size = cat.getWorldHooks().size();
					final List<Integer> rolls = diceService.roll(size, 1);
					for (int j : rolls) {
						values.add(cat.getWorldHooks().get(j - 1));
					}
				}
			}
		}
		return values;
	}

	public WorldHook createWorldHook(final WorldHook entity) {
		final WorldHookCategory category = worldHookCategoryDAO.find(entity.getCategory().getId());
		entity.setCategory(null);
		worldHookDAO.add(entity);
		entity.setCategory(category);
		category.getWorldHooks().add(entity);
		worldHookCategoryDAO.add(category);
		return entity;
	}

	public WorldHook updateWorldHook(final WorldHook entity) {
		final WorldHookCategory category = worldHookCategoryDAO.find(entity.getCategory().getId());
		entity.setCategory(null);
		worldHookDAO.update(entity);
		entity.setCategory(category);
		category.getWorldHooks().add(entity);
		worldHookCategoryDAO.update(category);
		return entity;
	}

	public WorldHook readWorldHook(final int id) {
		return worldHookDAO.find(id);
	}

	public List<WorldHook> listWorldHooks() {
		return worldHookDAO.list();
	}

	public void deleteWorldHook(final WorldHook entity) {
		worldHookDAO.remove(entity);
	}

	public void deleteWorldHook(final int id) {
		final WorldHook entity = readWorldHook(id);
		deleteWorldHook(entity);
	}

	public WorldHookCategory createWorldHookCategory(final WorldHookCategory entity) {
		if (entity.getWorldHooks() != null) {
			for (WorldHook hook : entity.getWorldHooks()) {
				worldHookDAO.update(hook);
			}
		}
		worldHookCategoryDAO.add(entity);
		return entity;
	}

	public WorldHookCategory updateWorldHookCategory(final WorldHookCategory entity) {
		if (entity.getWorldHooks() != null) {
			for (WorldHook hook : entity.getWorldHooks()) {
				worldHookDAO.update(hook);
			}
		}
		worldHookCategoryDAO.update(entity);
		return entity;
	}

	public WorldHookCategory readWorldHookCategory(final int id) {
		return worldHookCategoryDAO.find(id);
	}

	public List<WorldHookCategory> listWorldHookCategories() {
		return worldHookCategoryDAO.list();
	}

	public void deleteWorldHookCategory(final WorldHookCategory entity) {
		worldHookCategoryDAO.remove(entity);
	}

	public void deleteWorldHookCategory(final int id) {
		final WorldHookCategory entity = readWorldHookCategory(id);
		deleteWorldHookCategory(entity);
	}
}
