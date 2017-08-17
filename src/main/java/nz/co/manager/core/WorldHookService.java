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
public class WorldHookService extends CRUDService<WorldHook> {

	private final WorldHookCategoryDAO worldHookCategoryDAO;
	private final DiceService diceService;

	@Inject
	public WorldHookService(final WorldHookDAO worldHookDAO, final WorldHookCategoryDAO worldHookCategoryDAO,
			final DiceService diceService) {
		super(worldHookDAO);
		this.worldHookCategoryDAO = worldHookCategoryDAO;
		this.diceService = diceService;
	}

	public List<WorldHook> generate(final int times) throws ServiceException {
		final List<WorldHookCategory> categories = worldHookCategoryDAO.list();
		final WorldHookCategory lastCategory = categories.get(categories.size() - 1);
		final int max = lastCategory.getMax();
		final List<WorldHook> values = new ArrayList<>();
		final List<Integer> randomCats = diceService.roll(max, times);
		for (final int i : randomCats) {
			for (final WorldHookCategory cat : categories) {
				if (cat.getMin() <= i && cat.getMax() >= i) {
					final int size = cat.getWorldHooks().size();
					final List<Integer> rolls = diceService.roll(size, 1);
					for (final int j : rolls) {
						values.add(cat.getWorldHooks().get(j - 1));
					}
				}
			}
		}
		return values;
	}

	@Override
	public WorldHook create(final WorldHook entity) {
		final WorldHookCategory category = worldHookCategoryDAO.find(entity.getCategory().getId());
		entity.setCategory(null);
		super.create(entity);
		entity.setCategory(category);
		category.getWorldHooks().add(entity);
		worldHookCategoryDAO.add(category);
		return entity;
	}

	@Override
	public WorldHook update(final WorldHook entity) {
		final WorldHookCategory category = worldHookCategoryDAO.find(entity.getCategory().getId());
		entity.setCategory(null);
		super.update(entity);
		entity.setCategory(category);
		category.getWorldHooks().add(entity);
		worldHookCategoryDAO.update(category);
		return entity;
	}
}
