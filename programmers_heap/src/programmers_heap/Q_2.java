package programmers_heap;

import java.util.*;

class Q_2 {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Comparator.reverseOrder());
        
        int index = 0;
        for(int i=0; i<k; i++){
            if(index<dates.length&&i==dates[index]){
                q.offer(supplies[index]);
                index++;
            }
            if(stock == 0) {
                stock += q.poll();
                answer++;
            }
            stock -=1;
        }
      
        return answer;
    }
}