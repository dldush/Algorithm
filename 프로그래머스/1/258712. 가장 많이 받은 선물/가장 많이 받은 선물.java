import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int friendLength = friends.length;
        HashMap<String, Integer> friendMap = new HashMap<>();
        for(int i = 0; i < friendLength; i++) {
            friendMap.put(friends[i], i);
        }
        
        int giftScore[] = new int[friendLength];
        int giftGraph[][] = new int[friendLength][friendLength];
        
        for(String gift : gifts) {
            String giftName[] = gift.split(" ");
            giftScore[friendMap.get(giftName[0])]++;
            giftScore[friendMap.get(giftName[1])]--;
            giftGraph[friendMap.get(giftName[0])][friendMap.get(giftName[1])]++;
        }
        
        int answer = 0;
        
        for(int i = 0; i < friendLength; i++) {
            int count = 0;
            for(int j = 0; j < friendLength; j++) {
                if(i == j) {
                    continue;
                }
                if(giftGraph[i][j] > giftGraph[j][i]) {
                    count++;
                }
                else if(giftGraph[i][j] == giftGraph[j][i]) {
                    if(giftScore[i] > giftScore[j])
                        count++;
                }
                if(answer < count) {
                    answer = count;
                }
            }
        }
        return answer;
    }
}