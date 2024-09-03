
import java.util.Scanner;

public class Main {
	static int N,M;
	static int [] arr;
	static StringBuilder sb = new StringBuilder();


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		
		arr=new int[M];
		
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
		
		for(int i=1; i<=N; i++) {
			arr[cnt]=i;
			perm(cnt+1);
		}
		
	}

}
