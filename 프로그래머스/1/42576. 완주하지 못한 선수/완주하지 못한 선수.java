import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> person = new HashMap<>();

        // 참가자 수를 카운트
        for (String p : participant) {
            person.put(p, person.getOrDefault(p, 0) + 1);
        }

        // 완주자 수를 감소
        for (String c : completion) {
            person.put(c, person.get(c) - 1);
        }

        // 값이 1인 사람이 완주 못한 사람
        for (String key : person.keySet()) {
            if (person.get(key) > 0) {
                return key;
            }
        }

        return "";  // 이론상 도달하지 않음
    }
}
