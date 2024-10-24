import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class Edge implements Comparable<Edge> {
        int A, B;
        double W;

        public Edge(int a, int b, double w) {
            A = a;
            B = b;
            W = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.W, o.W);
        }
    }

    // 정점 정보 (x좌표, y좌표)
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] p;
    static Point[] points;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        points = new Point[n + 1];
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }

        // 먼저 연결된 통로의 시작점과 끝점을 유니온 처리
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(findSet(a), findSet(b));
        }

        // 정점끼리 이을 수 있는 모든 통로 정보 저장
        Edge[] edges = new Edge[n*(n-1)/2]; // 연결할 수 있는 모든 연결선 개수
        int edgeIdx = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                double distance = Math.sqrt(Math.pow(points[i].x - points[j].x, 2) + Math.pow(points[i].y - points[j].y, 2));
                
                edges[edgeIdx++] = new Edge(i, j, distance);
            }
        }
        Arrays.sort(edges);

        double ans = 0.0; // 최소 통로 길이
        int pick = 0;

        for (Edge edge : edges) {
            int px = findSet(edge.A);
            int py = findSet(edge.B);

            if (px != py) {
                union(px, py);
                ans += edge.W;
                pick++;
            }

            // n-1개의 간선이 선택되면 MST가 완성되므로 중단
            if (pick == n - 1)
                break;
        }

        System.out.printf("%.2f", ans);
    }

    static int findSet(int x) {
        if (x != p[x])
            p[x] = findSet(p[x]); // 경로 압축
        return p[x];
    }

    static void union(int x, int y) {
        p[findSet(y)] = findSet(x); // 대표자를 찾아서 병합
    }
}