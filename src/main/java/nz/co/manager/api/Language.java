package nz.co.manager.api;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "language")
public class Language extends Idable {
	@Column
	private String name;
	@ElementCollection
	private List<String> commonSpeakers;
	@Column
	private String script;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<String> getCommonSpeakers() {
		return commonSpeakers;
	}

	public void setCommonSpeakers(final List<String> commonSpeakers) {
		this.commonSpeakers = commonSpeakers;
	}

	public String getScript() {
		return script;
	}

	public void setScript(final String script) {
		this.script = script;
	}
}
