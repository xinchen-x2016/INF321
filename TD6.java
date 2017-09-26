package graph;

public class TD6 {
	public static void main(String[] args) {
		ListeArcs l = new ListeArcs();
		Sommet s = new Sommet("Pekin", l);
		Sommet s2 = new Sommet("Shanghai", l);
		Arc a = new Arc(s, 10);
		l.la.add(a);
		System.out.println(s.toString());
		System.out.println(l);
		Graphe g = new Graphe();
		System.out.println(g);
		g.ajouterSommet(s);
		System.out.println(g);
		System.out.println(g.extraireSommet(s2.etiquette));
	}
}
