package nz.co.manager.api;

import java.util.ArrayList;
import java.util.List;

public class LandWaterMassResults {
	private LandWaterMass mass;
	private List<Integer> positions = new ArrayList<>();
	private List<Integer> sizes = new ArrayList<>();

	public LandWaterMass getMass() {
		return mass;
	}

	public void setMass(final LandWaterMass mass) {
		this.mass = mass;
	}

	public List<Integer> getPositions() {
		return positions;
	}

	public void setPositions(final List<Integer> positions) {
		this.positions = positions;
	}

	public List<Integer> getSizes() {
		return sizes;
	}

	public void setSizes(final List<Integer> sizes) {
		this.sizes = sizes;
	}
}
