import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static class Node implements Comparable<Node> {
		int from, to, value;

		Node(int from, int to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	} // Node end;

	static int[] parent;
	static int N, M;
	static List<Node> list;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		list = new ArrayList<>();
		parent = new int[N+1];
		int sum = 0;
		int maxEdge = 0;
		
		for(int i = 0; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int value = sc.nextInt();
			list.add(new Node(from, to, value));
		}

		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			
			if(find(node.from) != find(node.to)) {
				union(node.from, node.to);
				sum += node.value;
				maxEdge = node.value;
			}
		}
		
		int res = 0;
		res = sum - maxEdge;
		
		System.out.println(res);

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
	}

} // class end