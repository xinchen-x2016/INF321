package structure;
public class Counter {
	int cntVal = 0;
	
	public void inc(){
		cntVal ++;
	}
	public void dec(){
		cntVal --;
	}
	
	public static void main(String[] args) {
		int n=20;            //number of loop
		Counter cnt = new Counter();
		Stack ope = new Stack();
		int i = 0;
		while(i < n){
			int x =(int)(Math.random()*3);
			System.out.print(i+ " ");   //for test: the ist loop
			System.out.print(x+" ");    //for test: value of x
			if(x == 0){
				cnt.inc();
				ope.push(0);
				
			}
			else if(x == 1){
				cnt.dec();
				ope.push(1);
			}
			else{
				Node y = ope.pop();
				if(y != null){
					if(y.value == 1) cnt.dec();
					else cnt.inc();
				}
				else continue;
			}
			System.out.println(cnt.cntVal);
			i ++;
		}
	}
}
