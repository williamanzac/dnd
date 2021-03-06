package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "mountainplacement")
public class MountainPlacement extends Idable {
	@Column
	private String type;
	@Column
	private int min;
	@Column
	private int max;

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

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}
}
