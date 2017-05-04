package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ClassLevel {
	@Column
	private int level;
	@ManyToOne
	private CharacterClass characterClass;

	public int getLevel() {
		return level;
	}

	public void setLevel(final int level) {
		this.level = level;
	}

	public CharacterClass getCharacterClass() {
		return characterClass;
	}

	public void setCharacterClass(final CharacterClass characterClass) {
		this.characterClass = characterClass;
	}
}
