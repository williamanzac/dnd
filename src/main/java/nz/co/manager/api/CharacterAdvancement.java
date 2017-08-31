package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "characterAdvancement")
public class CharacterAdvancement extends Idable {
	@Column
	private int experience;
	@Column
	private int level;
	@Column
	private int proficiencyBonus;

	public int getExperience() {
		return experience;
	}

	public void setExperience(final int experience) {
		this.experience = experience;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(final int level) {
		this.level = level;
	}

	public int getProficiencyBonus() {
		return proficiencyBonus;
	}

	public void setProficiencyBonus(final int proficiencyBonus) {
		this.proficiencyBonus = proficiencyBonus;
	}
}
