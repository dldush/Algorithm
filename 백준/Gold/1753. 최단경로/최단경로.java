import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main { // 최단 경로(프림)

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

	static int V, E, K;
	static boolean[] visited;
	static List<Edge>[] list;
	static int[] dist;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();
		visited = new boolean[V + 1];
		list = new ArrayList[V + 1];
		dist = new int[V + 1];

		Arrays.fill(dist, 987654321);

		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int u = sc.nextInt(); // from
			int v = sc.nextInt(); // to
			int w = sc.nextInt(); // value
			list[u].add(new Edge(v, w));
		}

		dijkstra(K);
		for (int i = 1; i <= V; i++) {
			if (dist[i] != 987654321) {
				System.out.println(dist[i]);
			} else {
				System.out.println("INF");
			}
		}

	} // main end

	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (visited[cur.to]) {
				continue;
			}
			visited[cur.to] = true;

			for (Edge next : list[cur.to]) {
				if (dist[next.to] > dist[cur.to] + next.value) {
					dist[next.to] = dist[cur.to] + next.value;
					pq.offer(new Edge(next.to, dist[next.to]));
				}
			}
		}
	}

} // class end