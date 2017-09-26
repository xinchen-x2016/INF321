package graph;
import java.util.LinkedList;

public class ListeArcs {
	public LinkedList<Arc> la = new LinkedList<Arc>();
	
	public String toString(){
		String st = "";
		for(Arc a : la){
			st += a.toString();
		}
		return st;
	}
}
