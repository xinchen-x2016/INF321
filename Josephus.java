package structure;
import java.util.Scanner;
public class Josephus {
	private Node kid;
	private static Scanner scanner;
	public void init(int n){
		Node temp = new Node(1);
		kid = temp;
		for(int i = 1; i <= n-1; i++){
			kid.next = new Node(i+1);
			kid = kid.next;
		}
		kid.next = temp;
	}
	
	public static void main(String[] args) {
		Josephus jo = new Josephus();
		System.out.print("Donner la valeur de n: ");
		scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		jo.init(n);
		System.out.print("Donner la valeur de k: ");
		int k = scanner.nextInt();
		while (jo.kid != jo.kid.next){
			for(int i = 1; i<k; i++){
				jo.kid = jo.kid.next;
			}
			System.out.println(jo.kid.next.value + " ");
			jo.kid.next = jo.kid.next.next;
		}
		System.out.println();
		System.out.println("Ce qui reste est: "+jo.kid.value);
	}
}
