package graph;

public class Sommet{
	public String etiquette;
	public ListeArcs LA;
	
	Sommet(String e, ListeArcs l){
		etiquette = e;
		LA = l;
	}
	
	Sommet(String e){
		etiquette = e;
		LA = new ListeArcs();
	}
	
	public void ajouterArc(Sommet destination, int longueur){
		Arc a = new Arc(destination, longueur);
		LA.la.add(a);
	}
	
	public String toString(){
		return etiquette ;	
	}
}
