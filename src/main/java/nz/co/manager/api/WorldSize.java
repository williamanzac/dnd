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
	@Column
	private int mountainSizeAdjustment;
	@Column
	private String mountainSizeComment;

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

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(final int diameter) {
		this.diameter = diameter;
	}

	public int getWorldMapSize() {
		return worldMapSize;
	}

	public void setWorldMapSize(final int worldMapSize) {
		this.worldMapSize = worldMapSize;
	}

	public int getRegionMapSize() {
		return regionMapSize;
	}

	public void setRegionMapSize(final int regionMapSize) {
		this.regionMapSize = regionMapSize;
	}

	public int getMountainSizeAdjustment() {
		return mountainSizeAdjustment;
	}

	public void setMountainSizeAdjustment(final int mountainSizeAdjustment) {
		this.mountainSizeAdjustment = mountainSizeAdjustment;
	}

	public String getMountainSizeComment() {
		return mountainSizeComment;
	}

	public void setMountainSizeComment(final String mountainSizeComment) {
		this.mountainSizeComment = mountainSizeComment;
	}
}
