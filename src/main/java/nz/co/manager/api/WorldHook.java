package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "worldhook")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class WorldHook extends Idable {
	@ManyToOne
	private WorldHookCategory category;
	@Column
	private String name;

	public WorldHookCategory getCategory() {
		return category;
	}

	public void setCategory(final WorldHookCategory category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}
