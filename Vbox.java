package typo;

import java.awt.Graphics;

public class Vbox extends Group{
	double lineSkip;
	
	Vbox(double lin){
		lineSkip = lin;
	}
	
	public double getStretchingCapacity(){
		double s = 0;
		for (Box b : list){
			if (b.getStretchingCapacity() > s) s = b.getStretchingCapacity();
		}
		return s;
	}
	
	public void add(Box b){
		super.add(b);
	}
	
	public double getAscent(){
		double a = 0, t =0;
		if (list == null) return a;
		else{
			for(Box b:list){
				a = a + b.getAscent() + t;
				t = b.getDescent() + lineSkip;
			}
			return a;
		}
	}
	
	public double getDescent(){
		double d = 0;
		if (list == null) return d;
		else{
			for(Box b:list){
				d = b.getDescent();
			}
			return d ;
		}
	}
	
	public double getWidth(){
		double w = 0;
		for (Box b : list){
			if (b.getWidth() > w) w = b.getWidth();
		}
		return w;
	}
	
	public void doDraw(Graphics graph, double x, double y, double w){
		double Y = y;
		for(Box b : list){
			b.doDraw(graph, x, Y, w);
			Y = Y + lineSkip + b.getAscent() + b.getDescent();
		}
	}
	
	public String toString(){
		return "Vbox" + super.toString();
	}
}
