package algo.boruvka;

public class Subset {
	private Vertex parent;
	private int rank;
	
	public Subset( Vertex parent, int rank ) {
		this.parent = parent;
		this.rank = rank;
	}
	
	public Vertex getParent() {
		return this.parent;
	}
	
	public int getRank() {
		return this.rank;
	}

	public void setParent(Vertex parent) {
		this.parent = parent;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
