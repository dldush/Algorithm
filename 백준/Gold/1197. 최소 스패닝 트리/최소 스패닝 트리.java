import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int val;

        public Edge(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }

        @Override
        public int compareTo(Edge o) {
            return this.val - o.val;
        }
    }

    static void union(int a, int b) {
        int ap = find(a);
        int bp = find(b);
        if (ap != bp) parents[bp] = ap;
    }

    static int find(int a) {
        if (parents[a] == a) return a;
        else return parents[a] = find(parents[a]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parents = new int[v + 1];
        for (int i = 1; i <= v; i++) parents[i] = i;

        List<Edge> list = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            list.add(new Edge(start, end, val));
        }

        Collections.sort(list);

        int sum = 0;

        for (Edge edge : list) {
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                sum += edge.val;
            }
        }
        System.out.println(sum);
    }
}
