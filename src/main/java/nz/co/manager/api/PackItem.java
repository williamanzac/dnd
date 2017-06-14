package nz.co.manager.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import nz.co.manager.jdbi.Idable;

@Entity
@Table(name = "packitem")
public class PackItem extends Idable {
	@Column
	private Integer quantity;
	@ManyToOne(optional = false)
	private Gear item;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(final Integer quantity) {
		this.quantity = quantity;
	}

	public Gear getItem() {
		return item;
	}

	public void setItem(final Gear item) {
		this.item = item;
	}
}
