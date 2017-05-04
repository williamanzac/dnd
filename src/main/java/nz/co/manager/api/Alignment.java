package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "alignment")
public class Alignment extends Idable {
	// LAWFUL_GOOD, LAWFUL_NEUTRAL, LAWFUL_EVIL, NEUTRAL_GOOD, TRUE_NEUTRAL, NEUTRAL_EVIL, CHAOTIC_GOOD,
	// CHAOTIC_NEUTRAL, CHAOTIC_EVIL
	@Column
	private String name;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}
