package graph;
import tc.TC;

public class test {
	static Graphe lireGraphe(String name){
	    TC.lectureDansFichier(name);
	    int num = TC.lireInt();
	    String oriente = TC.lireMot();
	    TC.lireLigne();
	    boolean isoriente = oriente.equals("true");
	    Graphe g = new Graphe();
	    for(int i = 0; i < num; i++){
	        String nsrc = TC.lireMot();
	        String ndst = TC.lireMot();
	        int dist = TC.lireInt();
	        Sommet src = g.extraireSommet(nsrc);
	        Sommet dst = g.extraireSommet(ndst);
	        src.ajouterArc(dst, dist);
	        if(!isoriente)
	            dst.ajouterArc(src, dist);
	        TC.lireLigne();
	    }
	    return g;
	}
	
	public static void main(String[] Args){
		Graphe g = lireGraphe("C:/Users/³Âê¿/Desktop/graph0.txt");
		System.out.println(g.toString());
		System.out.println(g.toDOT());
		System.out.println(g.chemincourt("B"));
		System.out.println(g.atteignables("A"));
	}
}
