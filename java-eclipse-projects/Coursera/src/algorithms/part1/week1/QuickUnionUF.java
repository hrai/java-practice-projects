package algorithms.part1.week1;

public class QuickUnionUF {
	
	private int[] id;
	
	public QuickUnionUF(int n) {
		id = new int[n];
		
		for(int i=0; i<n; i++) {
			id[i] = i;
		}
	}
	
	private int root(int i) {
		while(id[i] != i) {
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int a = root(p);
		int b = root(q);
		id[a] = b;
	}
} 
