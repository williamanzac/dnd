package nz.co.manager.api;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "region")
public class Region extends Idable {
	@Column
	private Integer number;
	@ElementCollection
	@CollectionTable(name = "adjacentRegions", joinColumns = @JoinColumn(name = "region_id"))
	@Column(name = "adjacent")
	private Set<Integer> adjacentRegions;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Set<Integer> getAdjacentRegions() {
		return adjacentRegions;
	}

	public void setAdjacentRegions(Set<Integer> adjacentRegions) {
		this.adjacentRegions = adjacentRegions;
	}
}
