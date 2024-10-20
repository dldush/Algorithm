import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main { // 다익스트라

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
	}

	static int N, M, X;
	static int[] dist;
	static boolean[] visited;
	static ArrayList<Edge>[] list;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// initiate var
		N = sc.nextInt(); // V
		M = sc.nextInt(); // E
		X = sc.nextInt(); // destination
		list = new ArrayList[N + 1];

		// make list
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		// input Edges
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int value = sc.nextInt();
			list[from].add(new Edge(to, value));
		}
		
		// cal distance
		int max = 0;
		for (int i = 1; i <= N; i++) {
			int totalDistance = dijkstra(i, X) + dijkstra(X, i); 
			max = Math.max(max, totalDistance);
		}

		System.out.println(max);
	}

	static int dijkstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(dist, 987654321); 
		dist[start] = 0;
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (visited[cur.to])
				continue;
			visited[cur.to] = true;

			for (Edge next : list[cur.to]) {
				if (dist[next.to] > dist[cur.to] + next.value) {
					dist[next.to] = dist[cur.to] + next.value;
					pq.offer(new Edge(next.to, dist[next.to]));
				}
			}
		}

		return dist[end];
	}
}