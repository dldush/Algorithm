import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node> {
    int to, value;
    
    public Node(int to, int value) {
        this.to = to;
        this.value = value;
    }
        public int compareTo(Node o) {
			return this.value - o.value;
		}
}
    
    static int N,K;
    static int[] dis;
    static boolean[] visited;
    static List<Node>[] list;
    
    public int solution(int n, int[][] road, int k) {
        
        N = n;
        K = k;
        visited = new boolean[N+1];
        dis = new int[N+1];
        list = new ArrayList[N+1];
        int answer = 0;

        for(int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < road.length; i++ ) {
            int from = road[i][0];
            int to = road[i][1];
            int value = road[i][2];
            list[from].add(new Node(to, value));
            list[to].add(new Node(from, value));
        }
        Arrays.fill(dis, 500001);
        dijkstra(1);
        for(int i = 1; i < N+1; i++){
            if(dis[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
    static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dis[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.to]) {
				continue;
			}
			visited[cur.to] = true;
			for(Node next : list[cur.to]) {
				if(dis[next.to] > dis[cur.to] + next.value) {
					dis[next.to] = dis[cur.to] + next.value;
					pq.offer(new Node(next.to, dis[next.to]));
				}
			}
			
		}
	}
}