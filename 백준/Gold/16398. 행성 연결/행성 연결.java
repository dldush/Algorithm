import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class Edge implements Comparable<Edge> {
		int to, value;

		Edge(int to, int value) {
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {
			return this.value - o.value;
		}
	} // Edge end

	static int V;
	static boolean[] visited;
	static List<Edge>[] list;
	static int[][] planet;
	static int count;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// initiate var
		V = sc.nextInt();
		visited = new boolean[V];
		list = new ArrayList[V];
		planet = new int[V][V];
		long sum = 0;

		// input planet
		for (int r = 0; r < V; r++) {
			for (int c = 0; c < V; c++) {
				planet[r][c] = sc.nextInt();
			}
		}

		for (int r = 0; r < V; r++) {
			list[r] = new ArrayList<>();
			for (int c = 0; c < V; c++) {
				list[r].add(new Edge(c, planet[r][c]));
			}
		}

		// Prim
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (visited[cur.to]) {
				continue;
			}
			visited[cur.to] = true;
			sum += cur.value;

			for (Edge next : list[cur.to]) {
				if (!visited[next.to]) {
					pq.offer(next);
				}
			}

		}

		System.out.println(sum);

	}

}