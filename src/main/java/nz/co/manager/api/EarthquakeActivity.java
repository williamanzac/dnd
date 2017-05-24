package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "earthquakeactivity")
public class EarthquakeActivity extends Idable {
	@Column
	private EarthquakeStrength strength;
	@Column
	private EarthquakeFrequency frequency;
	@Column
	private int min;
	@Column
	private int max;

	public EarthquakeStrength getStrength() {
		return strength;
	}

	public void setStrength(final EarthquakeStrength strength) {
		this.strength = strength;
	}

	public EarthquakeFrequency getFrequency() {
		return frequency;
	}

	public void setFrequency(final EarthquakeFrequency frequency) {
		this.frequency = frequency;
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
