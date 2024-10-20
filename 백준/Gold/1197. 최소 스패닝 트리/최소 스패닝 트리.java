import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static class Node implements Comparable<Node> {
		int start;
		int end;
		int value;

		public Node(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	} // node end

	static int V, E;
	static int[] parent;
	static List<Node> list;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();
		list = new ArrayList<>();
		parent = new int[V + 1];

		for (int i = 0; i <= V; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int value = sc.nextInt();

			list.add(new Node(start, end, value));
		}

		Collections.sort(list);

		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);

			if (find(node.start) != find(node.end)) {
				union(node.start, node.end);
				sum += node.value;
			}
		}

		System.out.println(sum);

	} // main end

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[b] = a;
		}
	}

	static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

} // class end