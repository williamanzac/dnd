package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "armour")
public class Armour extends Item {
	@Column
	private ArmourType category;
	@Column
	private Integer minStrength;
	@Column
	private Integer baseAC;
	@Column
	private boolean disadvantage;

	public ArmourType getCategory() {
		return category;
	}

	public void setCategory(final ArmourType category) {
		this.category = category;
	}

	public Integer getMinStrength() {
		return minStrength;
	}

	public void setMinStrength(final Integer minStrength) {
		this.minStrength = minStrength;
	}

	public Integer getBaseAC() {
		return baseAC;
	}

	public void setBaseAC(final Integer baseAC) {
		this.baseAC = baseAC;
	}

	public boolean isDisadvantage() {
		return disadvantage;
	}

	public void setDisadvantage(final boolean disadvantage) {
		this.disadvantage = disadvantage;
	}
}
