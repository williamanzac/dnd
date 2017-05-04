package nz.co.manager.api;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "character")
public class Character extends Idable {
	@Column
	private String name;
	@OneToOne
	private Race race;
	@Embedded
	private List<ClassLevel> characterClasses;
	@Column
	private Integer hitPoints;
	@Column
	private Integer maxHitPoints;
	@Column
	private Integer xp;

	@OneToOne
	private AbilityScore strength;
	@OneToOne
	private AbilityScore dexterity;
	@OneToOne
	private AbilityScore constitution;
	@OneToOne
	private AbilityScore intelligence;
	@OneToOne
	private AbilityScore wisdom;
	@OneToOne
	private AbilityScore charisma;

	@OneToOne
	private Alignment alignment;
	@ElementCollection
	private List<String> equipment;
	@Column
	private Integer gp;
	@Column
	private Integer ac;

	public Race getRace() {
		return race;
	}

	public void setRace(final Race race) {
		this.race = race;
	}

	public List<ClassLevel> getCharacterClasses() {
		return characterClasses;
	}

	public void setCharacterClasses(final List<ClassLevel> characterClasses) {
		this.characterClasses = characterClasses;
	}

	public Integer getMaxHitPoints() {
		return maxHitPoints;
	}

	public void setMaxHitPoints(final Integer maxHitPoints) {
		this.maxHitPoints = maxHitPoints;
	}

	public Integer getXp() {
		return xp;
	}

	public void setXp(final Integer xp) {
		this.xp = xp;
	}

	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(final Alignment alignment) {
		this.alignment = alignment;
	}

	public List<String> getEquipment() {
		return equipment;
	}

	public void setEquipment(final List<String> equipment) {
		this.equipment = equipment;
	}

	public Integer getGp() {
		return gp;
	}

	public void setGp(final Integer gp) {
		this.gp = gp;
	}

	public Integer getAc() {
		return ac;
	}

	public void setAc(final Integer ac) {
		this.ac = ac;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Integer getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(final Integer hitPoints) {
		this.hitPoints = hitPoints;
	}

	public AbilityScore getStrength() {
		return strength;
	}

	public void setStrength(final AbilityScore strength) {
		this.strength = strength;
	}

	public AbilityScore getDexterity() {
		return dexterity;
	}

	public void setDexterity(final AbilityScore dexterity) {
		this.dexterity = dexterity;
	}

	public AbilityScore getConstitution() {
		return constitution;
	}

	public void setConstitution(final AbilityScore constitution) {
		this.constitution = constitution;
	}

	public AbilityScore getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(final AbilityScore intelligence) {
		this.intelligence = intelligence;
	}

	public AbilityScore getWisdom() {
		return wisdom;
	}

	public void setWisdom(final AbilityScore wizdom) {
		wisdom = wizdom;
	}

	public AbilityScore getCharisma() {
		return charisma;
	}

	public void setCharisma(final AbilityScore charisma) {
		this.charisma = charisma;
	}
}
