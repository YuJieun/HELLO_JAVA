package programmers_Stack_Queue;

import java.util.*;

class Q_5 {
    public int solution(String arrangement) {
        int answer = 0;
        Deque<Character> dq = new LinkedList<>();

        
        for(int i=0; i<arrangement.length();i++){
            dq.addLast(arrangement.charAt(i));
        }
        
        int stick = 0;
        while(!dq.isEmpty()){
            if(dq.removeFirst()=='('){
                if(dq.peekFirst()==')'){
                    dq.removeFirst();
                    answer += stick;
                }else{
                    stick++;
                }
            }
            else{
                answer += 1;
                stick--;
            }
        }
        return answer;
    }
}