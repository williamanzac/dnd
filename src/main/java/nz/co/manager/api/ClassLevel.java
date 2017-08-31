package nz.co.manager.api;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Embeddable
public class ClassLevel {
	@OneToOne
	private CharacterAdvancement level;
	@ManyToOne
	private CharacterClass characterClass;

	public CharacterAdvancement getLevel() {
		return level;
	}

	public void setLevel(final CharacterAdvancement level) {
		this.level = level;
	}

	public CharacterClass getCharacterClass() {
		return characterClass;
	}

	public void setCharacterClass(final CharacterClass characterClass) {
		this.characterClass = characterClass;
	}
}
