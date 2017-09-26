package structure;
public class LinkedList {
	private Node seq;
	
	public LinkedList (Node node){
		seq = node;
	}
	
	public LinkedList(){
		seq = null;
	}
	
	public boolean add(int index, int val){
		Node t = seq;
		if(index == 0){
			seq = new Node(val,seq);
			return true;
		}
		else{
			int i=0;
			while(i < index){
				t = t.next;
				i ++;
				if (t == null) return false;
			}
			t.next = new Node(val, t.next);
			return true;
		}
	}
	
	public int get(int index){
		Node t = seq;
		if (index == 0) return t.value;
		for (int i=0; i<index; i++){
			if (t.next == null) return Integer.MIN_VALUE;
			t = t.next;
		}
		return t.value;
	}
	
	public boolean remove(int index){
		Node t = seq;
		if (index ==0){
			seq = seq.next;
			return true;
		}
		for (int i=0; i<index-1; i++){
			if(t.next == null) return false;
			t = t.next;
		}
		if (t.next != null){
			t.next = t.next.next;
			return true;
		}
		return false;
	}
	
	boolean set(int index, int val){
		Node t = seq;
		if(seq == null) return false;
		if (index == 0){
			seq.value = val;
			return true;
		}
		for(int i=0; i<index; i++){
			if(t.next == null) return false;
			t = t.next;
		}
		t.value = val;
		return true;
	}
	
	public int size(){
		int m = 0;
		Node t = seq;
		while(t != null){
			t = t.next;
			m ++;
		}
		return m;
	}
	
	public boolean contains(int val){
		Node t = seq;
		while(t != null){
			if (t.value == val) return true;
			t = t.next;
		}
		return false;
	}
	
	public String toString(){
		if (seq == null) return null;
		else{
			if (seq.next == null) return (seq.value + "->null");
			else return (seq.value + "->" + seq.next.toString());
		}
	}
	
	public int[] toArray(){
		int m = size();
		if(m ==0) return null;
		Node t = seq;
		int[] q = new int[m];
		for(int i=0; i<m; i++){
			q[i] = t.value;
			t = t.next;
		}
		return q;
	}
	
	public static void main(String[] args) {       //test
		LinkedList L = new LinkedList();
		System.out.println(L.toString());
		L = new LinkedList(new Node(5));
		System.out.println(L.toString());
		L.add(0, 4);
		System.out.println(L.toString());
		L.add(1, 3);
		System.out.println(L.toString());
		System.out.println(L.get(0));
		System.out.println(L.get(2));
		System.out.println(L.get(5));
		System.out.print(L.remove(0) + " ");
		System.out.println(L.toString());
		System.out.print(L.remove(3) + " ");
		System.out.println(L.toString());
		System.out.println(L.set(3, 100));
		System.out.println(L.set(0, 9));
		for(int i=0; i<L.size(); i++){
			System.out.print(L.toArray()[i]+" ");
		}
	}
}
