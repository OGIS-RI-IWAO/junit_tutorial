package cucumber.porker.pat;

public class FourCards extends Pat {
	public final int no;

	public FourCards(int no) {
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
		FourCards other = (FourCards) obj;
		if (no != other.no)
			return false;
		return true;
	}
}
