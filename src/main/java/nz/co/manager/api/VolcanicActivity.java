package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "volcanicactivity")
public class VolcanicActivity extends Idable {
	@Column
	private String activity;
	@Column
	private int min;
	@Column
	private int max;

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
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
