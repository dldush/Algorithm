import java.util.Scanner;

public class Main {

    static int N, M;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N+1];
        answer = new int[M];

        perm(0);

    }

    public static void perm(int depth) {

        if(depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {

            if (!visited[i]) {

               visited[i] = true;
               answer[depth] = i;
               perm(depth + 1);
               visited[i] = false;

            }

        }
    }
}
