import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] answer;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        answer = new int[M];
        visited = new boolean[N + 1];

        combi(1, 0);
    }

    public static void combi(int idx, int depth) {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = i;
                combi(i,depth + 1);
                visited[i] = false;
            }

        }


    }
}
