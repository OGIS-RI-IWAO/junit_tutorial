package cucumber.porker;

public class TwoPairs extends Pat {
	public final int no1;
	public final int no2;

	TwoPairs(int no1, int no2) {
		this.no1 = no1;
		this.no2 = no2;
	}

	// hashCode,equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no1 + no2;
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
		TwoPairs other = (TwoPairs) obj;
		if (no1 != other.no1)
			return false;
		if (no2 != other.no2)
			return false;
		return true;
	}
}
