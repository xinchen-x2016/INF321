package structure;
public class BankAccount {
	private int balance;
	
	public void credit(){
		balance ++;
	}
	
	public boolean debit(){
		if(0 < balance){
			balance --;
			return true;
		}
		else return false;
	}
	
	public String toString(){
		return balance + "";
	}
	
	public static void main(String[] args){
		BankAccount B = new BankAccount();
		B.balance = 0;
		Queue ope = new Queue();
		int n = 20;     //times of loops
		int i = 0;
		while (i < n){
			int t = (int)(Math.random()*4);
			if(t == 0){
				i ++;
				ope.enqueue(-1);
				System.out.println("debit operation submitted sold = "+ B.toString());
			}
			else if(t == 1){
				i ++;
				ope.enqueue(1);
				System.out.println("crebit operation submitted sold = "+B.toString());
			}
			else {
				Node m = ope.dequeue();
				if (m == null) continue;
				i ++;
				if (m.value == 1){
					B.credit();
					System.out.println("crebit operation applied sold = "+B.toString());
				}
				else{
					B.debit();
					System.out.println("debit operation applied sold = "+B.toString());
				}
			}
		}
	}
}
