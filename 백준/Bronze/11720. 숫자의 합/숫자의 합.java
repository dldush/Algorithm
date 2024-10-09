import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		int sum = 0;
		String str = sc.next();
		for(int i = 0; i < N; i++) {
			arr[i] = str.charAt(i) - '0';
			sum += arr[i];
		}
		
		System.out.println(sum);
		
	}

}