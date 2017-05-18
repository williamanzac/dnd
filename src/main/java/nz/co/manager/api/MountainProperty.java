package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "mountainproperty")
public class MountainProperty extends Idable {
	@Column
	private String characteristic;
	@Column
	private int min;
	@Column
	private int max;

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

	public String getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}
}
