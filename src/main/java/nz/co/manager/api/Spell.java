package nz.co.manager.api;

import java.util.EnumSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "spell")
public class Spell extends Idable {
	@Column
	private int level;
	@OneToOne
	private Duration castingTime; // seconds?
	@Column
	private int range; // range/area
	@Column
	private EnumSet<Component> components;
	@OneToOne
	private Duration duration; // seconds?
	@OneToOne
	private School school;
	@Column
	private AttackType attackType; // attack
	@Column
	private DamageType damage; // damage/effect
	@OneToOne
	private Ability saveRequired;
	@OneToOne
	private Condition condition;
	@Column
	private boolean concentration; // requires concentration
	@Column
	private boolean reaction; // can be used as a reaction
	@Column
	private boolean ritual; // is a ritual
	@ElementCollection
	private List<String> tags;
	@ManyToMany
	@JoinTable(name = "spell_classes")
	private List<CharacterClass> classes;
	@Column
	private String description;

	public int getLevel() {
		return level;
	}

	public void setLevel(final int level) {
		this.level = level;
	}

	public Duration getCastingTime() {
		return castingTime;
	}

	public void setCastingTime(final Duration castingTime) {
		this.castingTime = castingTime;
	}

	public int getRange() {
		return range;
	}

	public void setRange(final int range) {
		this.range = range;
	}

	public EnumSet<Component> getComponents() {
		return components;
	}

	public void setComponents(final EnumSet<Component> components) {
		this.components = components;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(final Duration duration) {
		this.duration = duration;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(final School school) {
		this.school = school;
	}

	public AttackType getAttackType() {
		return attackType;
	}

	public void setAttackType(final AttackType attack) {
		attackType = attack;
	}

	public DamageType getDamage() {
		return damage;
	}

	public void setDamage(final DamageType damage) {
		this.damage = damage;
	}

	public boolean isConcentration() {
		return concentration;
	}

	public void setConcentration(final boolean concentration) {
		this.concentration = concentration;
	}

	public boolean isReaction() {
		return reaction;
	}

	public void setReaction(final boolean reaction) {
		this.reaction = reaction;
	}

	public boolean isRitual() {
		return ritual;
	}

	public void setRitual(final boolean ritual) {
		this.ritual = ritual;
	}

	public Ability getSaveRequired() {
		return saveRequired;
	}

	public void setSaveRequired(final Ability saveRequired) {
		this.saveRequired = saveRequired;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(final Condition condition) {
		this.condition = condition;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(final List<String> tags) {
		this.tags = tags;
	}

	public List<CharacterClass> getClasses() {
		return classes;
	}

	public void setClasses(final List<CharacterClass> classes) {
		this.classes = classes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}
}
