package programmers_Brute_Force;

import java.util.*;

class Q_3 {
    public int solution(int[][] baseball) {
        int answer = 0;
        for(int i=123; i<=987; i++){
            String number = String.valueOf(i);
            if(number.charAt(0)==number.charAt(1)|| number.charAt(0)==number.charAt(2) || number.charAt(1)==number.charAt(2))
                continue;
            if(number.charAt(0)=='0'||number.charAt(1)=='0'||number.charAt(2)=='0')
                continue;
            
            //조건 체크          
            int j;
            for(j=0; j<baseball.length; j++){
                String check = String.valueOf(baseball[j][0]);
                int ball=0;
                int strike=0;
                for(int k=0; k<3;k++){
                    if(check.charAt(k)==number.charAt(k))
                        strike++;
                    else if(number.contains(Character.toString(check.charAt(k))))
                        ball++;
                }
                
                if(ball == baseball[j][2] && strike == baseball[j][1]){
                    continue;
                }else{
                    break;
                }
            }
            if(j==baseball.length){
                answer++;
            }
        }
        
        return answer;
    }
}