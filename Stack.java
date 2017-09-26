package structure;
public class Stack {
	private Node top;
	
	public Stack(int x){
		top = new Node(x);
	}
	
	public Stack(Node node){
		top = node;
	}
	
	public Stack(){
		top = null;
	}
	
	public void push(int val){
		top = new Node(val, top);
	}
	
	public Node pop(){
		if (top == null) return null;
		else{
			Node s = new Node(top.value);
			top = top.next;
			return s;
		}
	}
	
	public boolean isEmpty(){
		if (top == null) return true;
		else return false;
	}
	
	public boolean contains(int val){
		Node t = top;
		while(t.next != null){
			if (val == t.value) return true;
			else t = t.next;
		}
		return false;
	}
	
	public String toString(){
		if (top == null) return null;
		else{
			if(top.next == null) return top.value + "-> null";
			else return top.value + "->" + top.next.toString();
		}
	}
	
	public static void main(String[] args){
		Stack test = new Stack(5);
		System.out.println(test.toString());
		
		test.pop();
		System.out.println(test.toString());
		
		test.push(9);
		System.out.println(test.toString());
		
		Stack test2 = new Stack(new Node(5,new Node(3)));
		System.out.println(test2.toString());
		
		test2.push(1);
		test2.push(6);
		System.out.println(test2.toString());
		
		System.out.println(test2.contains(5));
		System.out.println(test2.contains(9));
		
		System.out.println(test2.pop());
		System.out.println(test2.toString());
	}
}
