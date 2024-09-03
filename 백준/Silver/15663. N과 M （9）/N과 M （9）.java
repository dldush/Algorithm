
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N,M;
	static int [] arr,numbers;
	static boolean [] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		
		arr=new int[M];
		numbers=new int[N];
		visited=new boolean[N];
		
		for(int i=0; i<N; i++) {
			numbers[i]=sc.nextInt();
		}
		
		Arrays.sort(numbers);
		
		perm(0);
	}

	static void perm(int cnt) {
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				System.out.print(arr[i]+" ");
			}System.out.println();
			return;
		}
		
		int past=0;
		
		for(int i=0; i<N; i++) {
			if(!visited[i]&& past!=numbers[i]) {
				visited[i]=true;
				arr[cnt]=numbers[i];
				past=numbers[i];
				perm(cnt+1);
				visited[i]=false;
			}
		}
		
	}

}
