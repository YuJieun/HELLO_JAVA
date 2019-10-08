package programmers_sort;

import java.util.*;

class Q_3 {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        
        for(int i = 0; i < citations.length; i++) {
            if (citations[i]>= citations.length-i) {
                answer = citations.length-i;
                break;
            }
        }  
        return answer;   
    }
}