package graph;
import java.util.*;

public class Graphe implements Sommets{
	public ListeSommets LS = new ListeSommets();
	
	public String toString() {
		String liste = "";
		for (Sommet i : LS.ls) {
			for (Arc j : i.LA.la) {
				liste += i.toString() + " " + j.destination.toString() +
						" " + j.longueur + "\n";
			}
		}
		return liste;
	}

	public void ajouterSommet(Sommet s) {
		LS.ls.add(s);
	}

	public Sommet extraireSommet(String nom) {
		for(Sommet s : LS.ls){
			if (s.etiquette.equals(nom)) return s;
		}
		Sommet s = new Sommet(nom);
		LS.ls.add(s);
		return s;
	}
	
	public Set<Sommet> atteignables(Sommet s){
		Set<Sommet> A = new HashSet<Sommet>();
		A.add(s);
		int n = A.size();
		int temp = 0;
		while(n != temp){
			temp = A.size();
			for(Sommet S : A){
				for(Arc a : S.LA.la){
					A.add(a.destination);
				}
			}
			n = A.size();
		}
		return A;
	}
	
	public Set<Sommet> atteignables(String s){
		return atteignables(extraireSommet(s));
	}

	public Map<Sommet, Integer> chemincourt(Sommet s){
		Map<Sommet, Integer> cc = new HashMap<Sommet, Integer>();
		cc.put(s, 0);
		int n = cc.size();
		int temp = 0;
		while (n != temp) {
			temp = cc.size();
			for (Sommet S : cc.keySet()) {
				for (Arc a : S.LA.la) {
					cc.putIfAbsent(a.destination, cc.get(S) + a.longueur);
					cc.put(a.destination, Math.min(cc.get(a.destination),
							cc.get(S) + a.longueur));
				}
			}
			n = cc.size();
		}
		return cc;
	}
	
	public Map<Sommet, Integer> chemincourt(String sommet) {
		return chemincourt(extraireSommet(sommet));
	}
	
	public String toDOT(){
		String DOT = "digraph graphname {\n";
		for(Sommet s : LS.ls){
			for(Arc a : s.LA.la){
				DOT = DOT + "    " + s + "->" + a.destination +";\n";
			}
		}
		DOT += "}";
		return DOT;
	}
	
}
