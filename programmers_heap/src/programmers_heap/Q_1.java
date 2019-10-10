package programmers_heap;

import java.util.*;

class Q_1 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //Arrays.sort보단 우선순위 큐 이용
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int i=0; i<scoville.length; i++){
            q.offer(scoville[i]);
        }
        
        while(true){
            if(q.peek()>=K)
                break;
            if(q.size()==1&& q.peek()<K)
                return -1;
            int food1 = q.poll();
            int food2 = q.poll();
            q.offer(food1+ (food2*2));
            answer++;
        }
        
        return answer;
    }
}
