package graph;
public class Arc {
	public Sommet destination;
	public int longueur;
	
	Arc(Sommet d, int l){
		destination = d;
		longueur = l;
	}
	
	public String toString(){
		return destination.toString() + " " + longueur;
	}
}
