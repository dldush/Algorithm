import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] arr;
    static int N, K;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[100001];
        Arrays.fill(arr, -1);
        
        bfs(N);
        System.out.println(arr[K]);
    } 

    static void bfs(int start) {
        arr[start] = 0; 
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        while (!q.isEmpty()) {
            int tmp = q.poll();

            if (tmp == K) {
                break;
            }

            if (tmp + 1 <= 100000 && arr[tmp + 1] == -1) {
                arr[tmp + 1] = arr[tmp] + 1;
                q.offer(tmp + 1);
            }

            if (tmp - 1 >= 0 && arr[tmp - 1] == -1) {
                arr[tmp - 1] = arr[tmp] + 1;
                q.offer(tmp - 1);
            }

            if (tmp * 2 <= 100000 && arr[tmp * 2] == -1) {
                arr[tmp * 2] = arr[tmp] + 1;
                q.offer(tmp * 2);
            }
        }
    }

}