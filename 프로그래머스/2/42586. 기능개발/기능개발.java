import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // make list for temp ans
        List<Integer> tempAnswer = new ArrayList<>();
        
        for(int i = 0, day = 0; i < progresses.length; i++) {
            // check the progresses
            if(progresses[i] + speeds[i] * day < 100) {
                while(progresses[i] + speeds[i] * day < 100) {
                    day++;
                }
                tempAnswer.add(1);
            } else {
                // if progresses ended already
                int yesterday = tempAnswer.size() - 1;
                tempAnswer.set(yesterday, tempAnswer.get(yesterday) + 1);
            }
        }
        
        // list to array
        int[] answer = new int[tempAnswer.size()];
        for(int i = 0 ; i < tempAnswer.size(); i++) {
            answer[i] = tempAnswer.get(i);
        }
        
        return answer;
    }
}