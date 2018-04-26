package algo.boruvka;

public class Vertex {
	// This class does nothing for now. Could be extended to hold an actual location.
	private int index;
	
	public Vertex() {
		//
	}
	
	protected void setIndex( int index ) {
		this.index = index;
	}
	
	public int getIndex() {
		return this.index;
	}
}
