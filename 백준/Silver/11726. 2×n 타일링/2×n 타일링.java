import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        if (n == 1) {
            System.out.println(1);
            return;
        } else if (n == 2) {
            System.out.println(2);
            return;
        }
        
        long[] dp = new long[n+1];
        
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007; 
        }
        
        System.out.println(dp[n]);
        
    }
}