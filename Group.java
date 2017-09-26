package typo;

//import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;

public class Group extends Box{
	protected final LinkedList<Box> list = new LinkedList<Box>();
	
	public void add(Box b){
		list.add(b);
	}
	
	public double getWidth(){
		return width;
	}
	
	public double getAscent(){
		return ascent;
	}
	
	public double getDescent(){
		return descent;
	}
	
	public double getStretchingCapacity(){
		return stretchingCapacity;
	}

	public String toString(){
		String s = super.toString() + "{\n}";
		for(Box b : list){
			s = s.replaceAll("\n}", "\n    " 
					+ b.toString().replaceAll("\n","\n    ") + ",\n}");
		}
		return s;
	}

	@Override
	protected void doDraw(Graphics graph, double x, double y, double w) {
		// TODO Auto-generated method stub
		
	}
}
