import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int []arr;
	static boolean [] visited;

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		
		arr=new int[M];
		visited = new boolean[N+1];
	
		
		perm(0);

	}

	static void perm(int cnt) {
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				System.out.print(arr[i]+" ");
			}System.out.println();
			return;
			
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				arr[cnt]=i;
				perm(cnt+1);
				visited[i]=false;
			}
		}
	}

}