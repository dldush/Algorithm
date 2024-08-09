import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt(); // 테스트 케이스 수 입력 받기
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 예상 가격 개수 입력 받기
            int[] arr = new int[N]; // N개 크기의 배열 초기
 
            // 배열에 예상 가격 입력받기
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
 
            int max = arr[N-1]; // 배열 맨 뒤 값을 기본 최대값으로 두기
            long ans = 0; // 정답을 쌓을 정수 초기
             
            // 뒤에서 부터 순회하며 최대값 - 예상 가격, 최대값 갱신되면 다시 반
            for (int i = N-1 ; i >= 0 ; i--) {
                if(max >= arr[i]) {
                    ans += max - arr[i];
                } else {
                    max = arr[i];
                }
            }
            System.out.println("#"+tc+" "+ans);
        }
 
    }
 
}