package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "worldsize")
public class WorldSize extends Idable {
	@Column
	private int diameter;
	@Column
	private int min;
	@Column
	private int max;
	@Column
	private int worldMapSize;
	@Column
	private int regionMapSize;

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

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public int getWorldMapSize() {
		return worldMapSize;
	}

	public void setWorldMapSize(int worldMapSize) {
		this.worldMapSize = worldMapSize;
	}

	public int getRegionMapSize() {
		return regionMapSize;
	}

	public void setRegionMapSize(int regionMapSize) {
		this.regionMapSize = regionMapSize;
	}
}
