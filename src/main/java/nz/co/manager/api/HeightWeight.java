package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "heightWeight")
public class HeightWeight extends Idable {
	@Column
	private String type;
	@Column
	private int baseHeightInch;
	@Column
	private String heightModifier;
	@Column
	private int baseWeightLB;
	@Column
	private String weightModifier;

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public int getBaseHeightInch() {
		return baseHeightInch;
	}

	public void setBaseHeightInch(final int baseHeightInch) {
		this.baseHeightInch = baseHeightInch;
	}

	public String getHeightModifier() {
		return heightModifier;
	}

	public void setHeightModifier(final String heightModifier) {
		this.heightModifier = heightModifier;
	}

	public int getBaseWeightLB() {
		return baseWeightLB;
	}

	public void setBaseWeightLB(final int baseWieghtLB) {
		this.baseWeightLB = baseWieghtLB;
	}

	public String getWeightModifier() {
		return weightModifier;
	}

	public void setWeightModifier(final String weightModifier) {
		this.weightModifier = weightModifier;
	}
}
