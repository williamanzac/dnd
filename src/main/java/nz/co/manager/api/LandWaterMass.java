package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "landwatermass")
public class LandWaterMass extends Idable {
	@Column
	private int numRegions;
	@Column
	private String numMasses;
	@Column
	private int minSize;
	@Column
	private int maxSize;

	public int getNumRegions() {
		return numRegions;
	}

	public void setNumRegions(final int numRegions) {
		this.numRegions = numRegions;
	}

	public String getNumMasses() {
		return numMasses;
	}

	public void setNumMasses(final String numMasses) {
		this.numMasses = numMasses;
	}

	public int getMinSize() {
		return minSize;
	}

	public void setMinSize(final int minSize) {
		this.minSize = minSize;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(final int maxSize) {
		this.maxSize = maxSize;
	}
}
