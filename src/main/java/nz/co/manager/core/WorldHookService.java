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

	public WorldHook createWorldHook(final WorldHook hook) {
		final WorldHookCategory category = worldHookCategoryDAO.get(hook.getCategory().getId());
		hook.setCategory(null);
		final WorldHook worldHook = worldHookDAO.persist(hook);
		worldHook.setCategory(category);
		category.getWorldHooks().add(worldHook);
		worldHookCategoryDAO.persist(category);
		return worldHook;
	}

	public WorldHook updateWorldHook(final WorldHook hook) {
		final WorldHookCategory category = worldHookCategoryDAO.get(hook.getCategory().getId());
		hook.setCategory(null);
		final WorldHook worldHook = worldHookDAO.persist(hook);
		worldHook.setCategory(category);
		category.getWorldHooks().add(worldHook);
		worldHookCategoryDAO.persist(category);
		return worldHook;
	}

	public WorldHook readWorldHook(final int id) {
		return worldHookDAO.get(id);
	}

	public List<WorldHook> listWorldHooks() {
		return worldHookDAO.listAll();
	}

	public void deleteWorldHook(final WorldHook hook) {
		worldHookDAO.delete(hook);
	}

	public void deleteWorldHook(final int id) {
		final WorldHook hook = worldHookDAO.get(id);
		worldHookDAO.delete(hook);
	}

	public WorldHookCategory createWorldHookCategory(final WorldHookCategory hook) {
		return worldHookCategoryDAO.persist(hook);
	}

	public WorldHookCategory updateWorldHookCategory(final WorldHookCategory hook) {
		return worldHookCategoryDAO.persist(hook);
	}

	public WorldHookCategory readWorldHookCategory(final int id) {
		return worldHookCategoryDAO.get(id);
	}

	public List<WorldHookCategory> listWorldHookCategories() {
		return worldHookCategoryDAO.listAll();
	}

	public void deleteWorldHookCategory(final WorldHookCategory hook) {
		worldHookCategoryDAO.delete(hook);
	}

	public void deleteWorldHookCategory(final int id) {
		final WorldHookCategory hook = worldHookCategoryDAO.get(id);
		worldHookCategoryDAO.delete(hook);
	}
}
