package algo.boruvka;

public class Edge {
	private Vertex source;
	private Vertex dest;
	private int weight;
	
	public Edge( Vertex source, Vertex dest, int weight ) {
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}
	
	public Vertex getSource() {
		return this.source;
	}
	
	public Vertex getDest() {
		return this.dest;
	}
	
	public int getWeight() {
		return this.weight;
	}
}
