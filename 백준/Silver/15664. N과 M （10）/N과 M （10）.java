import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int []arr,numbers;

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
		
		
		comb(0,0);

	}

	static void comb(int cnt, int idx) {
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				System.out.print(arr[i]+" ");
			}System.out.println();
			return;
		}
		
		int past = 0;
		
		for(int i=idx; i<N; i++) {
			if(past!=numbers[i]) {
				arr[cnt]=numbers[i];
				past=numbers[i];
				comb(cnt+1, i+1);		
			}
		}	
	}
}
