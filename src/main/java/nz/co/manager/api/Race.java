package nz.co.manager.api;

import java.util.List;

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
	private List<AbilityScoreAdjustment> abilityScoreAdjustments;
	@ManyToOne
	private Race parent;
	@ElementCollection
	private List<String> languages;
	@Column
	private Integer speed;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<AbilityScoreAdjustment> getAbilityScoreAdjustments() {
		return abilityScoreAdjustments;
	}

	public void setAbilityScoreAdjustments(final List<AbilityScoreAdjustment> abilityScoreAdjustments) {
		this.abilityScoreAdjustments = abilityScoreAdjustments;
	}

	public Race getParent() {
		return parent;
	}

	public void setParent(final Race parent) {
		this.parent = parent;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(final List<String> languages) {
		this.languages = languages;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(final Integer speed) {
		this.speed = speed;
	}
}
