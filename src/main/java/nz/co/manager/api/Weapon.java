package nz.co.manager.api;

import java.util.EnumSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "weapon")
public class Weapon extends Item {
	@Column
	private WeaponType type;
	@Column
	private AttackType category;
	@Column
	private DamageType damageType;
	@Column
	private String damageAmount;
	@Column
	private String twohandedAmount;
	@Column
	private int rangeNormal;
	@Column
	private int rangeMax;
	@Column
	private EnumSet<WeaponProperties> properties;

	public WeaponType getType() {
		return type;
	}

	public void setType(final WeaponType type) {
		this.type = type;
	}

	public AttackType getCategory() {
		return category;
	}

	public void setCategory(final AttackType category) {
		this.category = category;
	}

	public DamageType getDamageType() {
		return damageType;
	}

	public void setDamageType(final DamageType damageType) {
		this.damageType = damageType;
	}

	public String getDamageAmount() {
		return damageAmount;
	}

	public void setDamageAmount(final String damageAmount) {
		this.damageAmount = damageAmount;
	}

	public String getTwohandedAmount() {
		return twohandedAmount;
	}

	public void setTwohandedAmount(final String twohandedAmount) {
		this.twohandedAmount = twohandedAmount;
	}

	public int getRangeNormal() {
		return rangeNormal;
	}

	public void setRangeNormal(final int rangeNormal) {
		this.rangeNormal = rangeNormal;
	}

	public int getRangeMax() {
		return rangeMax;
	}

	public void setRangeMax(final int rangeMax) {
		this.rangeMax = rangeMax;
	}

	public EnumSet<WeaponProperties> getProperties() {
		return properties;
	}

	public void setProperties(final EnumSet<WeaponProperties> properties) {
		this.properties = properties;
	}
}
