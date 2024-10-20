import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main { // 행성연결
	
	static class Node implements Comparable<Node>{
		int from;
		int to;
		int value;
		
		public Node(int from, int to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
		
	} // node end
	
	static int V;
	static int[] parent;
	static int[][] planet;
	static List<Node> list;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// var initiate
		V = sc.nextInt();
		parent = new int[V+1];
		list = new ArrayList<>();
		planet = new int[V][V];
		long sum = 0;
		
		// parent array initiate
		for(int i = 0; i <= V; i++) {
			parent[i] = i;
		}
		// input planet value
		for(int r = 0; r < V; r++) {
			for(int c = 0; c < V; c++) {
				planet[r][c] = sc.nextInt();
			}
		}
		
		// input Edge
		for(int r = 0; r < V; r++) {
			for(int c = 0; c < V; c++) {
				if(r < c) {
					list.add(new Node(r, c, planet[r][c]));
				}
			}
		}
		
		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			
			if(find(node.from)!=find(node.to)) {
				union(node.from, node.to);
				sum += node.value;
			}
		}
		
		System.out.println(sum);
		
	} // main end
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			parent[b] = a;
		}
	}
	

	static int find(int a) {
		if(a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	} // find end

} // class end