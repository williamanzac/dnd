package nz.co.manager.views;

import java.util.ArrayList;
import java.util.List;

import nz.co.manager.api.WorldHookCategory;

public class CategoryView {
	private int id;
	private String name;
	private int min;
	private int max;
	private List<WorldHookView> worldHooks = new ArrayList<>();

	public CategoryView(final WorldHookCategory category) {
		id = category.getId();
		name = category.getName();
		min = category.getMin();
		max = category.getMax();
		if (category.getWorldHooks() != null) {
			category.getWorldHooks().forEach(h -> {
				worldHooks.add(new WorldHookView(h));
			});
		}
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<WorldHookView> getWorldHooks() {
		return worldHooks;
	}

	public void setWorldHooks(final List<WorldHookView> worldHooks) {
		this.worldHooks = worldHooks;
	}

	public int getMin() {
		return min;
	}

	public void setMin(final int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(final int max) {
		this.max = max;
	}
}