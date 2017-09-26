package graph;
import java.util.LinkedList;

public class ListeSommets{
	public LinkedList<Sommet> ls = new LinkedList<Sommet>();
	
	public String toString(){
		String st = "";
		for(Sommet s : ls){
			st += s.toString();
		}
		return st;
	}
}
