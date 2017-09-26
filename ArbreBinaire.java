package structure;

class ArbreBinaire {
	private String valeur;
	private ArbreBinaire gauche;
	private ArbreBinaire droite;
	private int taille;
	
	public ArbreBinaire(String v, ArbreBinaire g, ArbreBinaire d, int a){
		valeur = v;
		gauche = g;
		droite = d;
		taille = a;
	}
	
	void affiche(){
		System.out.println(valeur);
		if (gauche != null) gauche.affiche();
		if (droite != null) droite.affiche();
	}
	
	void afficheTrier(){
		if (gauche != null) gauche.afficheTrier();
		System.out.println(valeur);
		if (droite != null) droite.afficheTrier();
	}
	
	boolean recherche(String v){
		int c = v.compareTo(valeur);
		if (c == 0) return true;
		else if (c < 0){
			if (gauche != null) return gauche.recherche(v);
			else return false;
		}
		else{
			if (droite != null) return droite.recherche(v);
			else return false;
		}
	}
	
	void ajouter(String v){
		int c = v.compareTo(valeur);
		if (c == 0) return;
		else if (c < 0){
			if (gauche != null) gauche.ajouter(v);
			else gauche = new ArbreBinaire(v, null, null,1);
			taille ++;
			return;
		}
		else{
			if (droite != null) droite.ajouter(v);
			else droite = new ArbreBinaire(v, null, null, 1);
			taille ++;
			return;
		}
	}
	
//	ArbreBinaire supdroite(){
//		if (droite == null) return gauche;
//		return droite.supdroite();
//	}
//	
//	ArbreBinaire supgauche(){
//		if(gauche == null) return droite;
//		return gauche.supgauche();
//	}
//	
//	ArbreBinaire suppression(){
//		if (gauche == null && droite == null) return null;
//		else if (gauche == null && droite != null) return supdroite();
//		else if (gauche != null && droite == null) return supgauche();
//		else{
//			int a = (int)(Math.random()*2);
//			if (a == 0) return supdroite();
//			else return supgauche();
//		}
//
//	}
//	
//	static ArbreBinaire retirer(ArbreBinaire T, String v){
//		if (T == null) return null;
//		if(v.compareTo(T.valeur) < 0) T.gauche = retirer(T.gauche, v);
//		if(v.compareTo(T.valeur) > 0) T.droite = retirer(T.droite, v);
//		if(v.compareTo(T.valeur) == 0) T.suppression();
//		return T;
//	}
//	
	static ArbreBinaire trouver(ArbreBinaire T){
		if(T == null) return null;
		if(T.droite != null) return trouver(T.droite);
		return T;
	}
	
	static ArbreBinaire ret(ArbreBinaire T){
		if(T == null) return null;
		if(T.droite == null) return T.gauche;
		T.droite = ret(T.droite);
		return T;
	}
	
	static ArbreBinaire retirer(ArbreBinaire T, String v){
		if (T == null) return null;
		if(v.compareTo(T.valeur) < 0) T.gauche = retirer(T.gauche, v);
		if(v.compareTo(T.valeur) > 0) T.droite = retirer(T.droite, v);
		if(v.compareTo(T.valeur) == 0){
			if(T.gauche == null) return T.droite;
			T.valeur = trouver(T.gauche).valeur;
			T.gauche = ret(T.gauche);
		}
		T.taille = 1 + ((T.gauche == null) ? 0 :T.gauche.taille) + 
				((T.droite == null) ? 0 :T.droite.taille);
		return T;
	}
	
	ArbreBinaire retirer(String v){
		return retirer(this, v);
	}
	
	int calculerTaille(){
		if((gauche != null) && (droite != null)) return(1 + gauche.calculerTaille() + droite.calculerTaille());
		else if((gauche != null) && (droite == null)) return (1 + gauche.calculerTaille());
		else if((gauche == null) && (droite != null)) return (1 + droite.calculerTaille());
		else return 1;
	}
	
	static boolean verifierTaille(ArbreBinaire T){
		if (T == null) return true;
		return ((T.calculerTaille() == T.taille) && (verifierTaille(T.gauche)) && (verifierTaille(T.droite)));
	}
	
	boolean verifierTaille(){
		return verifierTaille(this);
	}
	
	boolean verifierInf(String v){
		if(v.compareTo(valeur) > 0){
			if(droite != null) return droite.verifierInf(v);
			return true;
		}
		return false;
	}
	
	boolean verifierSup(String v){
		if(v.compareTo(valeur) < 0){
			if(gauche != null) return gauche.verifierSup(v);
			return true;
		}
		return false;
	}
		
	static boolean verifierTrier(ArbreBinaire T){
		if (T == null) return true;
		if (T.gauche != null && T.droite != null)
			return (T.gauche.verifierInf(T.valeur) && T.droite.verifierSup(T.valeur) 
				&& verifierTrier(T.gauche) && verifierTrier(T.droite));
		else if (T.gauche != null && T.droite == null)
			return (T.gauche.verifierInf(T.valeur) && verifierTrier(T.gauche));
		else if (T.gauche == null && T.droite != null)
			return (T.droite.verifierSup(T.valeur) && verifierTrier(T.droite));
		else return true;
	}
	
	boolean verifierTrier(){
		return verifierTrier(this);
	}
	
	public static void main(String[] args){
		ArbreBinaire b = new ArbreBinaire("has", 
				new ArbreBinaire("go", new ArbreBinaire("boldly", null, null, 1),
						new ArbreBinaire("gone", null, null, 1), 3),
				new ArbreBinaire("no", new ArbreBinaire("man", null, null, 1),
						new ArbreBinaire("where", null, null, 1), 3),7);
		
		System.out.println(b.taille);
		b.ajouter("xxx");
		System.out.println(b.taille);
		System.out.println(b.calculerTaille());
		System.out.println(b.verifierTaille());
		
//		ArbreBinaire c = new ArbreBinaire(
//			    "has", new ArbreBinaire("go", null, null, 1),
//			    new ArbreBinaire("no", null, null, 1), 3);
//
//		assert(c.verifierTaille());
//		c.taille = 10;
//		assert(c.verifierTaille());
//		c.ajouter("before");
//		assert(c.verifierTaille());
		             //exemple de l'arbre mal-formes
		
//		ArbreBinaire d = new ArbreBinaire("to",
//			  new ArbreBinaire("boldly", null, null, 1),
//			  new ArbreBinaire("go", null, null, 1), 3);
		
//		assert(d.verifierTrier());     //exemple de l'arbre mal trie

		ArbreBinaire d1 = new ArbreBinaire("go",
      		  new ArbreBinaire("boldly", null, null, 1),	
      		  new ArbreBinaire("to", null, null, 1), 3);
		
		assert(d1.verifierTrier());
		d1.ajouter("where");
		assert(d1.verifierTrier());
		d1.affiche();
		d1.retirer("go");
		System.out.println();
		d1.affiche();
		System.out.println(d1.taille);
	}
}
	
