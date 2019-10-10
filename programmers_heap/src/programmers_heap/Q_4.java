package programmers_heap;

import java.util.*;

class Q_4 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Queue<Integer> q = new LinkedList<>();
        for(String op : operations){
            if(op.charAt(0)=='I'){
                pq.offer(Integer.parseInt(op.substring(2)));
            }
            else if(op.charAt(2)=='1'){
                if(pq.size()==0)
                    continue;
                int len = pq.size()-1;
                for(int i=0; i<len; i++){
                    q.offer(pq.poll());
                }
                pq.poll();
                len = q.size();
                for(int i=0;i<len;i++){   
                    pq.offer(q.poll());
                }
                System.out.println(pq.size());
                System.out.println(q.size());
                
            }else{
                if(pq.size()==0)
                    continue;
                pq.poll();
            }
        }
        
        if(pq.size()>1){
            answer[1] = pq.poll();
            int len = pq.size()-1;
            for(int i=0;i<len;i++){
                pq.poll();
            }
            answer[0] = pq.poll();
        } 
        return answer;
    }
}