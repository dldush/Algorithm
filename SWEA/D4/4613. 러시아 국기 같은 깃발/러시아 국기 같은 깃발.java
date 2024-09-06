
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			
			char[][]arr = new char [N][M];
			
			for(int n=0; n<N; n++) {
				String str = sc.next();
				for(int m=0; m<M; m++) {
					arr[n][m]=str.charAt(m);
				}
			}
			
			int[][]color = new int[N][3];
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(arr[n][m]=='W') {
						color[n][0]++;
					}else if(arr[n][m]=='B') {
						color[n][1]++;
					}else if(arr[n][m]=='R') {
						color[n][2]++;
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			
			for(int bRow=0; bRow<N-2; bRow++) {
				for(int rRow=bRow+1; rRow<N-1; rRow++) {
					int wRow = N-1;
					int changes = 0;
					
					for(int i=0; i<=bRow; i++) {
						changes += M - color[i][0];
					}
					
					for(int i=bRow+1; i<=rRow; i++) {
						changes += M - color[i][1];
					}
					
					for(int i=rRow+1; i<=wRow; i++) {
						changes += M - color[i][2];
					}
					
					min = Math.min(changes, min);
				}
			}
			
			System.out.println("#"+tc+" "+min);
		}
	}
}