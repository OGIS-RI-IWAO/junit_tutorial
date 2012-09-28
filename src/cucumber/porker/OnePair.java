package cucumber.porker;

public class OnePair extends Pat {
	public final int no;

	OnePair(int no) {
		this.no = no;
	}

	// hashCode,equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
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
		OnePair other = (OnePair) obj;
		if (no != other.no)
			return false;
		return true;
	}

}
