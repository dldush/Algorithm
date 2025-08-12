import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, n, computers, visited);
                answer++; 
            }
        }
        return answer;
    }

    private void bfs(int start, int n, int[][] computers, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;      
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next = 0; next < n; next++) {
                
                if (computers[cur][next] == 1 && !visited[next]) {
                    visited[next] = true;   
                    q.offer(next);
                }
            }
        }
    }
}
