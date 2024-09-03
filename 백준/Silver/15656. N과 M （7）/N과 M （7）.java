import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int []arr,numbers;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		
		arr=new int[M];
		numbers=new int[N];
		
		for(int i=0; i<N; i++) {
			numbers[i]=sc.nextInt();
		}
		Arrays.sort(numbers);
		
		perm(0);
		System.out.println(sb);

	}

	static void perm(int cnt) {
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				sb.append(arr[i]).append(" ");
			}sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			arr[cnt]=numbers[i];
			perm(cnt+1);
		}
		
	}

}
