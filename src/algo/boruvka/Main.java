package algo.boruvka;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		ArrayList<Edge> edges = new ArrayList<Edge>();

		// Create all vertices used. Position is not relavent.
		Vertex v0 = new Vertex();
		Vertex v1 = new Vertex();
		Vertex v2 = new Vertex();
		Vertex v3 = new Vertex();
		vertices.add(v0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		
		// Create all edges. Vertex objects are used.
		Edge e0 = new Edge( v0, v1, 8 );
		Edge e1 = new Edge( v1, v3, 15 );
		Edge e2 = new Edge( v3, v2, 7 );
		Edge e3 = new Edge( v2, v0, 6 );
		edges.add(e0);
		edges.add(e1);
		edges.add(e2);
		edges.add(e3);
		
		Boruvka.makeGraph(vertices.toArray(new Vertex[vertices.size()]), edges.toArray(new Edge[edges.size()]));
	}
}
