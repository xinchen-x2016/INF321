package UnionFind;
public class Unionfind {
	static int[] equiv = new int[Percolation.length];
	static int[] height = new int[Percolation.length];
	
	static int find(int x){
		if(x != equiv[x]){
			equiv[x] = equiv[equiv[x]];
			x = equiv[x];
		}
		return x;
	}
	
	static void union(int x, int y){
		for(int i=0; i<height.length; i++){
			height[i] = 1;
		}
		int xId = find(x);
		int yId = find(y);
		
		if (xId == yId){
			return;
		}
		
		if(height[xId]<height[yId]) {equiv[xId] = yId; height[yId] += height[xId];}
		else {equiv[yId] = equiv[xId]; height[xId] += height[yId];}
	}
}
