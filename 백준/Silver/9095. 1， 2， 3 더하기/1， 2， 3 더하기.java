import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스 수
        for (int tc = 1; tc <= T; tc++) {

            int n = sc.nextInt();
            long[] dp = new long[n + 1];

            if (n == 0) {
                System.out.println("0");
            } else if (n == 1) {
                System.out.println("1");
            } else if (n == 2) {
                System.out.println("2");
            } else if (n == 3) {
                System.out.println("4");
            } else {
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;

                for (int i = 4; i <= n; i++) {
                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
                }

                System.out.println(dp[n]);
            }
        }

    }

}