package typo;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Box {
	protected double width, ascent, descent, stretchingCapacity;
	
	public abstract double getWidth();
	
	public abstract double getAscent();
	
	public abstract double getDescent();
	
	public abstract double getStretchingCapacity();
	
	final static boolean debug = false;
	
	public final void draw(Graphics graph, double x, double y, double w){
		if(debug) {
			graph.setColor(Color.red);
			graph.drawRect((int)x, (int)y, (int)w, (int)(getAscent() + getDescent()));
			graph.setColor(Color.black);
		}
		doDraw(graph, x, y, w);
	}
	
	protected abstract void doDraw(Graphics graph, double x, double y, double w);
	
	public String toString(){
		return "[w= " + getWidth() + ", a=" + getAscent() + 
				", d=" + getDescent() + ", sC=" + getStretchingCapacity() + "]";
	}
}
