class Solution {
    int answer, n;
    int[][] dg;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        dg = dungeons;
        n = dungeons.length;
        visited = new boolean[n];
        dfs(k, 0);
        return answer;
    }

    void dfs(int fatigue, int cleared) {
        answer = Math.max(answer, cleared);
        for (int i = 0; i < n; i++) {
            if (!visited[i] && fatigue >= dg[i][0]) {
                visited[i] = true;
                dfs(fatigue - dg[i][1], cleared + 1);
                visited[i] = false;
            }
        }
    }
}
