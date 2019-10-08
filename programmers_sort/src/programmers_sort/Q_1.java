package programmers_sort;

import java.util.*;

class Q_1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int[] tmp = new int[commands[i][1]-commands[i][0]+1];
            for(int j=0; j<tmp.length; j++){
                tmp[j] = array[j+commands[i][0]-1];
            }
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2]-1];
        }
        return answer;
    }
}