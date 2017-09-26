package structure;

public class Node {
	public int value;
	public Node next;
	
	Node(int v){
		value = v;
		next = null;
	}
	
	Node(int v, Node node){
		value = v;
		next = node;
	}
	
	public String toString(){
		if (next == null) return value + "->null";
		else return value + "->" + next.toString();
	}
	
	public static void main(String[] args){
		Node test = new Node(3, new Node(5, null));
		String contentTest = test.toString();
		System.out.println(contentTest);
		
		Node test2 = new Node(1, null);
		System.out.println(test2.toString());
		
		Node test3 = new Node(3, new Node(5, test2));
		System.out.println(test3);
	}
}
