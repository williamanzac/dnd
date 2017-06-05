package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "regionalhydrography")
public class RegionalHydrography extends Idable {
	@Column
	private String continentalForm;
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

	public String getContinentalForm() {
		return continentalForm;
	}

	public void setContinentalForm(final String percent) {
		continentalForm = percent;
	}
}
