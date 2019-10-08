package programmers_hash;

import java.util.*;

class Q_3 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap();
        
        for(int i=0;i<clothes.length;i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }
        
        for(String temp : map.keySet()){
            answer *= map.get(temp) +1;
        }
            
        //아무것도 안입는 경우 빼줌
        return answer-1;
    }
}