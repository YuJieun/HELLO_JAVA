package programmers_Stack_Queue;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Paper> q = new LinkedList<Paper>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<priorities.length; i++){
            q.offer(new Paper(priorities[i],i));
            arr.add(priorities[i]);
        }
        
        Collections.sort(arr);
        int cnt = 1;
        while(true){
            Paper tmp = q.poll();
            if(tmp.score == arr.get(arr.size()-1)){
                if(tmp.location == location)
                    return cnt;
                else{
                    arr.remove(arr.size()-1);
                    cnt++;
                }
            }else{
                q.offer(new Paper(tmp.score,tmp.location));
            }       
        }   
    }
}

class Paper{
    int score;
    int location;
    
    Paper(int s, int l){
        this.score = s;
        this.location = l;
    }
}