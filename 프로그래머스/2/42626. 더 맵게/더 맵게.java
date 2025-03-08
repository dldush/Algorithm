import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.offer(s);
        }

        int answer = 0;
        
        while (pq.size() >= 2) {
            int lowest = pq.poll();
            if (lowest >= K) { // 이미 K 이상이면 정답 반환
                return answer;
            }
            int second = pq.poll();
            int mixed = lowest + (second * 2);
            pq.offer(mixed);
            answer++;
        }

        // 마지막으로 남은 하나의 값이 K 이상인지 확인
        return pq.poll() >= K ? answer : -1;
    }
}
