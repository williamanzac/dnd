package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "regiontype")
public class RegionType extends Idable {
	@Column
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
