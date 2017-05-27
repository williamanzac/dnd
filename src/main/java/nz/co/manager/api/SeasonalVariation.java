package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "seasonalvariation")
public class SeasonalVariation extends Idable {
	@Column
	private String variation;
	@Column
	private int min;
	@Column
	private int max;

	public String getVariation() {
		return variation;
	}

	public void setVariation(final String name) {
		this.variation = name;
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
