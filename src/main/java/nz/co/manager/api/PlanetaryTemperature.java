package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "planeterarytemperature")
public class PlanetaryTemperature extends Idable {
	@Column
	private String category;
	@Column
	private int min;
	@Column
	private int max;

	public String getCategory() {
		return category;
	}

	public void setCategory(final String name) {
		category = name;
	}

	public int getMin() {
		return min;
	}

	public void setMin(final int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(final int max) {
		this.max = max;
	}
}
