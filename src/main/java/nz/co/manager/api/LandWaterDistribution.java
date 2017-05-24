package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "landwaterdistribution")
public class LandWaterDistribution extends Idable {
	@OneToOne
	private RegionType regionType;
	@OneToOne
	private DisplayType displayType;
	@OneToOne
	private WorldHydrography hydrography;
	@Column
	private int numRegions;

	public RegionType getRegionType() {
		return regionType;
	}

	public void setRegionType(final RegionType regionType) {
		this.regionType = regionType;
	}

	public DisplayType getDisplayType() {
		return displayType;
	}

	public void setDisplayType(final DisplayType displayType) {
		this.displayType = displayType;
	}

	public WorldHydrography getHydrography() {
		return hydrography;
	}

	public void setHydrography(final WorldHydrography hydrography) {
		this.hydrography = hydrography;
	}

	public int getNumRegions() {
		return numRegions;
	}

	public void setNumRegions(final int numRegions) {
		this.numRegions = numRegions;
	}
}
