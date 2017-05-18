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

	public void setDescription(String name) {
		this.description = name;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
}
