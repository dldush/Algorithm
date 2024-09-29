import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, V;
	static int[][] adjarr;
	static boolean[] visited;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		adjarr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjarr[a][b] = adjarr[b][a] = 1;
		}

		dfs(V);
		System.out.println();
		bfs(V);
		System.out.println();
		
	} // main end

	public static void dfs(int node) {
		
			visited[node] = true;
			System.out.print(node+" ");
			
			for (int i = 0; i <= N; i++) {
				
				if (adjarr[node][i] == 1 && !visited[i]) {
					dfs(i);
					
				}
			}
		
	}

	public static void bfs(int node) {
		
		visited = new boolean[N + 1];
		
		Queue<Integer> q = new LinkedList<>();
		visited[node] = true;

		q.offer(node);
	
		while (!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp+" ");
			for (int i = 0; i <= N; i++) {
				if (adjarr[temp][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}

}