package nz.co.manager.api;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "race")
public class Race extends Idable {
	@Column
	private String name;
	@ElementCollection
	private Set<AbilityScoreAdjustment> abilityScoreAdjustments;
	@ManyToOne
	private Race parent;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Set<AbilityScoreAdjustment> getAbilityScoreAdjustments() {
		return abilityScoreAdjustments;
	}

	public void setAbilityScoreAdjustments(final Set<AbilityScoreAdjustment> abilityScoreAdjustments) {
		this.abilityScoreAdjustments = abilityScoreAdjustments;
	}

	public Race getParent() {
		return parent;
	}

	public void setParent(final Race parent) {
		this.parent = parent;
	}
}
