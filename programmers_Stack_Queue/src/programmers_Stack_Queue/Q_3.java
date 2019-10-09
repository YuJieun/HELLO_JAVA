package programmers_Stack_Queue;

import java.util.*;

class Q_3 {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        for(int i=heights.length-1; i>=0;i--){
            int j;
            for(j=i-1; j>=0; j--){
                if(heights[j]>heights[i])
                    break;
            }
            if(j==-1)
                answer[i] = 0;
            else
                answer[i] = j+1;
        }
        
        return answer;
    }
}