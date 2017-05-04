package nz.co.manager.api;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "class")
public class CharacterClass extends Idable {
	@Column
	private String name;
	private Die hitDiceType;
	@ManyToMany(mappedBy = "classes")
	private List<Spell> spells;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<Spell> getSpells() {
		return spells;
	}

	public void setSpells(final List<Spell> spells) {
		this.spells = spells;
	}
}
