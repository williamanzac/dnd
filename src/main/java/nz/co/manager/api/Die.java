package nz.co.manager.api;

public enum Die {
	FOUR(4), SIX(6), EIGHT(8), TEN(10), TWENTY(20), PERCENT(100);

	private final int numSides;

	private Die(final int numSides) {
		this.numSides = numSides;
	}

	public int getNumSides() {
		return numSides;
	}

	public static Die getForSides(final int numSides) {
		for (final Die d : values()) {
			if (d.numSides == numSides) {
				return d;
			}
		}
		return null;
	}
}
