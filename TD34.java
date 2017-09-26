package structure;

public class TD34 {
	public static void main(String[] args){
		ArbreBinaire b = new ArbreBinaire("has", 
				new ArbreBinaire("go", new ArbreBinaire("boldly", null, null, 1),
						new ArbreBinaire("gone", null, null, 1), 3),
				new ArbreBinaire("no", new ArbreBinaire("man", null, null, 1),
						new ArbreBinaire("where", null, null, 1), 3),7);
		//System.out.print(b.valeur+" ");
		//System.out.print(b.gauche.valeur+" ");
		//System.out.println(b.droite.valeur);
		System.out.println();
		b.affiche();
		System.out.println();
		b.afficheTrier();
		System.out.println();
		System.out.println(b.recherche("to"));
		System.out.println(b.recherche("boldly"));
		System.out.println();
		b.ajouter("to");
		b.ajouter("before");
		b.affiche();
		assert(b.verifierTrier());
		b.retirer("has");
		System.out.println();
		b.affiche();
	}
}
