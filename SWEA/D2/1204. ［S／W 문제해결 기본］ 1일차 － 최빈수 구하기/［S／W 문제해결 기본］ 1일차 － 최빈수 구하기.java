import java.util.Scanner;

public class Solution { // 최빈값 구하기

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int t = sc.nextInt();

			int[] score = new int[1000];
			int[] counting = new int[101];

			for (int i = 0; i < 1000; i++) {
				score[i] = sc.nextInt();
			}

			int max = 0;
			int idx = 0;

			// 카운팅 배열에 카운트하기
			for (int i = 0; i < 1000; i++) {
				counting[score[i]]++;
			}
			// 카운팅 배열 최대값 찾고, 인덱스 값 저장하기
			for (int i = 0; i <= 100; i++) {
				if (counting[i] >= max) {
					max = counting[i];
					idx = i;
				}
			}
			System.out.println("#" + t + " " + idx);
		}
	} // tc end

}
