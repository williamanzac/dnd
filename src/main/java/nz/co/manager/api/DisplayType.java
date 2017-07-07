package nz.co.manager.api;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "displaytype")
public class DisplayType extends Idable {
	@Column
	private String name;
	@Column
	private Integer numRegions;
	@OneToMany
	private Set<Region> regions;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Integer getNumRegions() {
		return numRegions;
	}

	public void setNumRegions(Integer numRegions) {
		this.numRegions = numRegions;
	}

	public Set<Region> getRegions() {
		return regions;
	}

	public void setRegions(Set<Region> regions) {
		this.regions = regions;
	}
}
