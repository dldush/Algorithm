import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int N = sc.nextInt();
		int[]money = new int[N+1];
		int[]cnt = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			money[i]=sc.nextInt();
			cnt[i]=sc.nextInt();
		}
		
		int sumM=0;
		for(int i=1; i<=N; i++) {
			sumM+= money[i]*cnt[i];
		}
		
		if(X==sumM) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}sc.close();
		}

}