package programmers_hash;

import java.util.*;

//arraylist로 품. 효율성 fail

class Q_1_wrong {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(participant));
        for(int i=0;i<completion.length;i++){
            arr.remove(completion[i]);
        }
        
        answer = arr.get(0);

        return answer;
    }
}