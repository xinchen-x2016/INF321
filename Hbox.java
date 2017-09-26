package typo;

import java.awt.Graphics;

public class Hbox extends Group{
	
	public void add(Box b){
		super.add(b);
	}
	
	public double getStretchingCapacity(){
		double s = 0;
		for(Box b : list){
			s += b.getStretchingCapacity();
		}
		return s;
	}
	
	public double getAscent(){
		double a = 0;
		for(Box b:list){
			if (b.getAscent() > a) a= b.getAscent();
		}
		return a;
	}
	
	public double getDescent(){
		double d = 0;
		for(Box b:list){
			if (b.getDescent() > d) d= b.getDescent();
		}
		return d;
	}
	
	public double getWidth(){
		double w = 0;
		for(Box b : list){
			w += b.getWidth();
		}
		return w;
	}
	
	public void doDraw(Graphics graph, double x, double y, double w){
		double mw = getWidth();
		if (mw > w){
			System.out.println("'w' is too small!");
			doDraw(graph, x, y, mw);   
		}
		double di = w - mw;
		double d = 0;
		for(Box b : list){
			d += b.getStretchingCapacity();
		}
		double X = x, Y = y + getAscent();
		for(Box b : list){
			Y -= b.getAscent();
			double W = b.getWidth()+di*b.getStretchingCapacity()/d;
			b.doDraw(graph, X, Y, W);
			X += W;
			Y += b.getAscent();
		}
	}
	
	public String toString(){
		return "Hbox" + super.toString();
	}
}
