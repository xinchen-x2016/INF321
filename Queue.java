package structure;
public class Queue {
	private Node first;
	private Node last;
	
	public Queue(Node node){
		last = node;
		first = last;
	}
	
	public Queue(){
		last = null;
		first = last;
	}
	
	public Queue(int v){
		last = new Node(v);
		first = last;
	}
	
	public void enqueue(int val){
		if (first == null){  
			last = new Node(val);
			first = last;
		}
		else{
			last.next = new Node(val);
			last = last.next;
		}
	}
	
	public Node dequeue(){
		if (first == null) return null;
		else{
			Node s = new Node(first.value);
			first = first.next;
			return s;
		}
	}
	
	public boolean contains(int val){
		Node t = first;
		while(t != null){
			if (t.value == val) return true;
			t = t.next;
		}
		return false;
	}
	
	public boolean isEmpty(){
		if (first == null) return true;
		else return false;
	}
	
	public String toString(){
		if(first == null) return null;
		else{
			if (first.next == null) return first.value + "->null";
			else return first.value + "->" + first.next.toString();
		}
	}
	
	public static void main(String[] args) {
		Queue test = new Queue(5);
		System.out.println(test.toString());
		test.dequeue();
		System.out.println(test.toString());
		test.enqueue(3);
		test.enqueue(4);
		System.out.println(test.toString());
		test.dequeue();
		System.out.println(test.toString());
		System.out.println(test.contains(5));
		System.out.println(test.contains(4));
	}
}
