package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "worldhook")
public class WorldHook extends Idable {
	@ManyToOne
	private WorldHookCategory category;
	@Column
	private String name;

	public WorldHookCategory getCategory() {
		return category;
	}

	public void setCategory(WorldHookCategory category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
