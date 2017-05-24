package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "platemovement")
public class PlateMovement extends Idable {
	@Column
	private String description;
	@Column
	private int min;
	@Column
	private int max;

	public String getDescription() {
		return description;
	}

	public void setDescription(final String name) {
		description = name;
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
