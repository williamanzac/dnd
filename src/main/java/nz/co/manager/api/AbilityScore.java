package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "abilityScore")
public class AbilityScore extends Idable {
	@Column
	private Integer score;

	@Column
	private Integer modifier;

	public Integer getScore() {
		return score;
	}

	public void setScore(final Integer score) {
		this.score = score;
	}

	public Integer getModifier() {
		return modifier;
	}

	public void setModifier(final Integer modifier) {
		this.modifier = modifier;
	}
}
