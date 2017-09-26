package UnionFind;
import tc.TC;

public class Percolation {
	static int size=10;
	static int length = size*size;
	static boolean[] grid = new boolean[length];
	
	public void init(){
		for(int i=0; i<length; i++){
			grid[i] = false;   //blanche
			Unionfind.equiv[i] = i;
		}
	}
	
	public void print(){
		for(int i=0; i<length; i++){
			if(grid[i]==false) TC.print("-"); //blanche
				else TC.print("*");
			if((i+1)%size==0) TC.print("\n");
		}
	}
	
	public int random_shadow(){
		int k=(int)(length*Math.random());
		while(grid[k] == true){
			//TC.println(grid[k]);
			k=(int)(length*Math.random());
			//TC.println(k);
		}
		grid[k] = true;
		return k;
	}
	
	
	public boolean is_percolation(int n){
		/*boolean[] seen = new boolean[length];
		boolean p = false;
		for(int i=length-size; i<length; i++)
			if(grid[i]==true){
				seen[i] = true;
				p = true;
			}
		boolean up = false;
		//TC.print(n);    //test
		if (p) return detect_path(seen, n-1, up);  
		else return false;*/
		for(int i=0; i<size; i++){
			if(Unionfind.find(i)==Unionfind.find(n)){
				for(int j=length-size; j<length; j++){
					if(Unionfind.find(n)==Unionfind.find(j)) return true;
				}
			}
		}
		return false;
				
	}          //connecte et passe par n 
		
	
	/*public boolean detect_path(boolean[] seen, int n, boolean up){
		if((n>=1) && (up==false)){
			for(int i=0; i<length-1; i++){
				if(seen[i]){
					if(grid[i-size]) seen[i-size]=true;
					if(grid[i-1] && (i%size != 0)) seen[i-1]=true;
					if(grid[i+1] && (i%size != (size-1))) seen[i+1]=true;
				}
			}
			if(seen[length-1])
				if(grid[length-1-size]) seen[length-1-size]=true;
			for(int i=0; i<size; i++){
				if(seen[i]) up = true;
			}
		}
		if(up) return up;
		else if(n==0) return up;
		else return detect_path(seen, n-1, up);
	}*/
	
	public void propagate_union(int x){
		if(x>=1){
			if(grid[x-1] && (x%size !=0)) Unionfind.union(x-1, x);
			if(x>=size){
				if(grid[x-size]) Unionfind.union(x-size, x);
			}
		}
		if(x<length-1){
			if(grid[x+1] && (x%size != size-1)) Unionfind.union(x+1, x);
			if(x<length-size){
				if(grid[x+size]) Unionfind.union(x+size, x);
				}
		}
		
	}
	
	public int percolation(){
	    int r = random_shadow(), count=1;
	    propagate_union(r);
	    
		while (is_percolation(r)==false){
			r = random_shadow();
			propagate_union(r);
			count++;
		}
		return count;
	}
	
	public float montecarlo(int n){
		float sum=0;
		for(int i=1; i<=n; i++){
			Percolation m = new Percolation();
			m.init();
			sum += m.percolation();
		}
		float seuil = sum/(length*n);
		return seuil;
	}
	
	public static void main(String[] args) {
		Percolation m = new Percolation();
		m.init();
		TC.print("Donner le fois de simulations:");
		int n = TC.lireInt();
		long time = System.currentTimeMillis();
		TC.println(m.montecarlo(n));
		time =  System.currentTimeMillis() - time;
		TC.println(time);
	}
}