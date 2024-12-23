import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        int[] answer = {0, 0};
        
        for (int i = 0; i < words.length; i++) {
            // 1. 끝말잇기 규칙 확인
            if (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                answer[0] = (i % n) + 1; // 1번부터 시작하는 플레이어 번호
                answer[1] = (i / n) + 1; // 차례 계산
                return answer;
            }
            
            // 2. 중복 단어 확인
            if (list.contains(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                return answer;
            }
            
            // 3. 단어를 리스트에 추가
            list.add(words[i]);
        }

        // 모든 끝말잇기가 성공한 경우
        return new int[] {0, 0};
    }
}
