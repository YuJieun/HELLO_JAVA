package programmers_hash;

import java.util.*;

//hashmap으로 품

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap();
        for(String temp : completion){
            if(map.containsKey(temp)){
                int cnt = map.get(temp);
                map.remove(temp);
                map.put(temp,cnt+1);
            }else{
                map.put(temp,1);
            }
        }
        
        for(String temp : participant){
            if(map.containsKey(temp) && map.get(temp)>1){
                int cnt = map.get(temp);
                map.remove(temp);
                map.put(temp, cnt-1);
            }else if(map.containsKey(temp)){
                map.remove(temp);
            }else{
                answer = temp;
                break;
            }
        }
        
        return answer;
    }
}