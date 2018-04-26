package algo.boruvka;

import java.util.ArrayList;

public class Boruvka {
	public static ArrayList<Edge> makeGraph(Vertex[] vertices, Edge[] edges) {
		
		Subset[] subsets = new Subset[vertices.length];
		int[] cheapest = new int[subsets.length];
		for (int i = 0; i < subsets.length; i++) {
			vertices[i].setIndex(i);
			Subset s = new Subset( vertices[i], 0 );
			subsets[i] = s;
			cheapest[i] = -1;
		}
		
		int treesLeft = vertices.length;
		ArrayList<Edge> mst = new ArrayList<Edge>();
		
		while( treesLeft > 1 ) {
			for (int i = 0; i < edges.length; i++) {
				Vertex set1 = find( subsets, edges[i].getSource() );
				Vertex set2 = find( subsets, edges[i].getDest() );
				
				if ( set1.equals(set2) ) {
					continue;
				}

				int indx1 = set1.getIndex();
				int indx2 = set2.getIndex();

				if ( cheapest[indx1] == -1 || edges[cheapest[indx1]].getWeight() > edges[i].getWeight()) {
					cheapest[indx1] = i;
				}
				
				if ( cheapest[indx2] == -1 || edges[cheapest[indx2]].getWeight() > edges[i].getWeight()) {
					cheapest[indx2] = i;
				}
			}
			
			for (int i = 0; i < vertices.length; i++) {
				if ( cheapest[i] == -1 ) 
					continue;

				Vertex set1 = find(subsets, edges[cheapest[i]].getSource());
				Vertex set2 = find(subsets, edges[cheapest[i]].getDest());

				if ( set1.equals(set2) )
					continue;
				
				mst.add(edges[cheapest[i]]);
				union( subsets, vertices, set1, set2 );
				treesLeft--;
			}
		}
		
		System.out.println("Minimum Spanning Tree...");
		for (int i = 0; i < mst.size(); i++) {
			Edge e = mst.get(i);
			System.out.println("From " + e.getSource().getIndex() + " to " + e.getDest().getIndex());
		}
		return mst;
	}
	
	public static Vertex find( Subset[] subsets, Vertex vertex ) {
		Subset subset = subsets[vertex.getIndex()];
		Vertex parent = subset.getParent();
		
		if ( !parent.equals(vertex) ) {
			subset.setParent( find( subsets, parent) );
		}
		
		return subset.getParent();
	}
	
	public static void union( Subset[] subsets, Vertex[] vertices, Vertex x, Vertex y ) {
		Vertex xroot = find( subsets, x );
		Vertex yroot = find( subsets, y );
		
		Subset subx = subsets[xroot.getIndex()];
		Subset suby = subsets[yroot.getIndex()];
		
		if ( subx.getRank() < suby.getRank() ) {
			subx.setParent(yroot);
		} else if ( subx.getRank() > suby.getRank() ) {
			suby.setParent(xroot);
		} else {
			suby.setParent(xroot);
			subx.setRank(subx.getRank()+1);
		}
	}
}
