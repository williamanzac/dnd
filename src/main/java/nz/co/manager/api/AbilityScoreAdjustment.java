package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class AbilityScoreAdjustment {
	@OneToOne
	private Ability ability;
	@Column
	private Integer modifier;

	public Integer getModifier() {
		return modifier;
	}

	public void setModifier(final Integer modifier) {
		this.modifier = modifier;
	}

	public Ability getAbility() {
		return ability;
	}

	public void setAbility(final Ability ability) {
		this.ability = ability;
	}
}
