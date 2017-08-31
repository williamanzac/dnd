package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "skill")
public class Skill extends Idable {
	@Column
	private String name;
	@OneToOne
	Ability ability;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Ability getAbility() {
		return ability;
	}

	public void setAbility(final Ability ability) {
		this.ability = ability;
	}
}
