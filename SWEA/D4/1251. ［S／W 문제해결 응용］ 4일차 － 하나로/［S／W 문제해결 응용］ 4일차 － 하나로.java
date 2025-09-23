import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int[] parents;

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        double dis;

        public Edge(int start, int end, double dis) {
            this.start = start;
            this.end = end;
            this.dis = dis;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.dis > o.dis) return 1;
            else if (this.dis < o.dis) return -1;
            else return 0;
        }
    }

    static void union(int a, int b) {
        int ap = parents[a];
        int bp = parents[b];

        if (ap != bp) parents[bp] = ap;
    }

    static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int N = Integer.parseInt(br.readLine());

            long[] x = new long[N];
            long[] y = new long[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                x[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                y[i] = Long.parseLong(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine());

            parents = new int[N];
            for (int i = 0; i < N; i++) {
                parents[i] = i;
            }

            List<Edge> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    double dis = Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2);

                    list.add(new Edge(i, j, dis));
                }
            }

            Collections.sort(list);

            double ans = 0;
            for (Edge edge : list) {
                if (find(edge.start) != find(edge.end)) {
                    union(edge.start, edge.end);
                    ans += edge.dis;
                }
            }

            System.out.println("#" + tc + " " + Math.round(E*ans));
        }
    }
}
