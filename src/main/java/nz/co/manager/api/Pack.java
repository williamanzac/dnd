package nz.co.manager.api;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pack")
public class Pack extends Item {
	@OneToMany
	private List<PackItem> items;

	public List<PackItem> getItems() {
		return items;
	}

	public void setItems(final List<PackItem> items) {
		this.items = items;
	}
}
