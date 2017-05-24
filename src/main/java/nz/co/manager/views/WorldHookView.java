package nz.co.manager.views;

import nz.co.manager.api.WorldHook;

public class WorldHookView {
	private int id;
	private String name;

	public WorldHookView(final WorldHook hook) {
		id = hook.getId();
		name = hook.getName();
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
}