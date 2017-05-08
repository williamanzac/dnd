package nz.co.manager.api;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "worldhookcategory")
public class WorldHookCategory extends Idable {
	@Column
	private String name;
	@Column
	private int min;
	@Column
	private int max;
	@OneToMany
	private List<WorldHook> worldHooks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public List<WorldHook> getWorldHooks() {
		return worldHooks;
	}

	public void setWorldHooks(List<WorldHook> worldHooks) {
		this.worldHooks = worldHooks;
	}
}
