package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import nz.co.manager.jdbi.Idable;

@MappedSuperclass
public class Item extends Idable {
	@Column
	private String name;
	@Column
	private float costGP;
	@Column
	private float weightLB;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public float getCostGP() {
		return costGP;
	}

	public void setCostGP(final float costGP) {
		this.costGP = costGP;
	}

	public float getWeightLB() {
		return weightLB;
	}

	public void setWeightLB(final float weightLB) {
		this.weightLB = weightLB;
	}
}
