package nz.co.manager.api;

import java.util.ArrayList;
import java.util.List;

public class PlateResults {
	private List<Integer> positions = new ArrayList<>();
	private List<Integer> sizes = new ArrayList<>();

	public List<Integer> getPositions() {
		return positions;
	}

	public void setPositions(List<Integer> positions) {
		this.positions = positions;
	}

	public List<Integer> getSizes() {
		return sizes;
	}

	public void setSizes(List<Integer> sizes) {
		this.sizes = sizes;
	}
}
