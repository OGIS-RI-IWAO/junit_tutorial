package cucumber.porker;

public class RoyalStraightFlash extends Pat {
	// hashCode,equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + 60;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}
