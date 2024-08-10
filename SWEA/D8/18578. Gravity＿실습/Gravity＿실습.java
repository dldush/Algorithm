import java.util.Scanner;

public class Solution { // Gravity 실습

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int[] room = new int[N];
			
			for(int i = 0 ; i < N ; i++) {
				room[i] = sc.nextInt();
			}
			
			int max = 0; // 최댓값 저장할 정
			

			for (int i = 0; i < N; i++) {
				int cnt = 0; // 낙차 
				for(int j = i+1 ; j < N ; j++) {
					if(room[i] > room[j]) {
						cnt++;
					} 
					max = Math.max(max, cnt);
				}
				
			}
			System.out.println("#"+tc+" "+max);
		} // tc end
	}

}
