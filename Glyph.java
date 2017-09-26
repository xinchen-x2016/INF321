package typo;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;


public class Glyph extends Box{
	
	final private static FontRenderContext frc = new FontRenderContext(null, false, false);
	final private Font font;
	final private char[] chars;
	final private Rectangle2D bounds;
	
	Glyph(Font font, char c){
		this.font = font;
		chars = new char[1];
		chars[0] = c;
		TextLayout layout = new TextLayout(""+chars[0], font, frc);
		bounds = layout.getBounds();
	}
	
	public double getStretchingCapacity(){
		return 0;
	}
	
	public double getWidth(){
		return bounds.getWidth();
	}
	
	public double getAscent(){
		return -bounds.getY();
	}
	
	public double getDescent(){
		return bounds.getHeight() + bounds.getY();
	}
	
//	public String toString(){
//		return "Glyph(" +chars[0] + ")[w=" + getWidth() + ", a=" + getAscent() + 
//				", d=" + getDescent() + ", sC=" + getStretchingCapacity() + "]";
//	}
	
	public String toString(){
		return "Glyph(" + chars[0] + ")" +super.toString();
	}
	
	public void doDraw(Graphics graph, double x, double y, double w){
		graph.setFont(font);
		graph.drawChars(chars, 0, 1, (int)(x-bounds.getX()), (int)(y-bounds.getY()));
	}
	
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
	
	public static void main(String[] args){
		test2();
	}
}
