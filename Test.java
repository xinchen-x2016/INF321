package typo;

import java.awt.Font;

public class Test {
	static void test1(){
		Font f = new Font("SansSerif", Font.PLAIN, 70);
		Glyph g = new Glyph(f, 'g');
		System.out.println(g);
	}
	
	static void test2(){
		Font f = new Font("SansSerif", Font.PLAIN, 70);
		Glyph g = new Glyph(f, 'g');
		System.out.println(g);
		new Page(g, 150, 150);
	}
	
	static void test4(){
		Font f = new Font("SansSerif", Font.PLAIN, 70);
		Space s = new Space(2, 3);
		FixedSpace fs = new FixedSpace(5);
		RelativeSpace rs = new RelativeSpace(0.5, f);
		System.out.println(s);
		System.out.println(fs);
		System.out.println(rs);
	}
	
	static void test5(){
		Font f = new Font("SansSerif", Font.PLAIN, 70);
		Group g = new Group();
		Group g0 = new Group();
		g0.add(new Space(2,3));
		g0.add(new FixedSpace(5));
		g.add(g0);
		g.add(new RelativeSpace(0.5,f));
		System.out.println(g);
	}
	
	static void test6a() {
	    Hbox h = new Hbox();
	    System.out.println(h);
	    Font f = new Font("SansSerif", Font.PLAIN, 40);
	    h.add(new Glyph(f, 'a'));
	    System.out.println(h);
	    h.add(new Space(2., 3.));
	    System.out.println(h);
	}
	
	static Hbox lineFromString(Font f, String s) {
	    Hbox line = new Hbox();
	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (c == ' ')
	            line.add(new RelativeSpace(0.5, f));
	        else {
	            line.add(new Glyph(f, c));
	            if (i < s.length()-1 && s.charAt(i+1)!=' ')
	                line.add(new FixedSpace(2));
	        }
	    }
	    return line;
	}

	static void test6b() {
	    Font f = new Font("SansSerif", Font.PLAIN, 40);
	    Box t = lineFromString(f, "Typographie sans peine");
	    System.out.println(t);
	    new Page(t, 450, 150);
	}
	
	static void test6c() {
		  Font f = new Font("SansSerif", Font.PLAIN, 40);
		  Box t = lineFromString(f, "Test");
		  System.out.println(t);
		  new Page(t, 450, 150);
		}
	
	final static Box hfill = new Space(0, Double.POSITIVE_INFINITY);

	static Vbox fromString(Font f, String s) {
	    Vbox text = new Vbox(5);
	    int len = s.length();
	    for (int i = 0; i < len; ) {
	        int idx = s.indexOf('\n', i);
	        if (idx == -1) idx = len;
	        Hbox line = lineFromString(f, s.substring(i, idx));
	        if (idx == len) line.add(hfill); // ajoute un ressort infini �� la fin de la derni��re ligne
	        text.add(line);
	        i = idx+1;
	    }
	    return text;
	}

	static void test7a() {
	    Font f = new Font("SansSerif", Font.PLAIN, 40);
	    Box t = fromString(f, "L'homme n'est qu'un\nroseau, le plus faible\nde la nature ; mais\nc'est un roseau pensant.");
	    new Page(t, 450);
	}
	
	static void test7b() {
	    Font f = new Font("SansSerif", Font.PLAIN, 30);
	    Font lettrinef = new Font("SansSerif", Font.PLAIN, 120);
	    Vbox t = new Vbox(5);
	    Hbox h = new Hbox();
	    h.add(new Glyph(lettrinef, 'L'));
	    h.add(new Space(3, 1));
	    Vbox l = new Vbox(5);
	    l.add(lineFromString(f, "'homme n'est qu'un roseau, le"));
	    l.add(lineFromString(f, "plus faible de la nature ; mais"));
	    l.add(lineFromString(f, "c'est un roseau pensant. Il ne"));
	    h.add(l);
	    t.add(h);
	    t.add(lineFromString(f, "faut pas que l'univers entier s'arme"));
	    t.add(lineFromString(f, "pour l'��craser : une vapeur, une"));
	    t.add(fromString(f, "goutte d'eau, suffit pour le tuer."));
	    new Page(t, 500);
	}
	
	public static void main(String[] args){
		test7b();
	}
}
