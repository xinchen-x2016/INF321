package typo;

import java.awt.Graphics;

public class Space extends Box{
	public double dimension;
	public double capacite;
	
	Space(double dim, double cap){
		dimension = dim;
		capacite = cap;
	}
	
	public void doDraw(Graphics graph, double x, double y, double w){
		return;
	}
	
	public double getAscent(){
		return 0;
	}
	
	public double getDescent(){
		return 0;
	}
	
	public String toString(){
		return "Space" + super.toString();
	}

	public double getWidth() {
		return dimension;
	}

	public double getStretchingCapacity() {
		return capacite;
	}

}
