package programmers_Brute_Force;

import java.util.*;

class Q_1 {
    public int[] solution(int[] answers) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[][] person = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        int[] right = new int[3];
        
        for(int i=0; i<answers.length; i++){
            for(int j=0; j<3; j++){
                int index = i%person[j].length;
                if(answers[i] == person[j][index])
                    right[j]++;
            }
        }
        
        int max = -1;
        for(int i=0; i<3; i++){
            if(right[i]>max){
                arr.clear();
                arr.add(i+1);
                max = right[i];
            }else if(right[i]==max){
                arr.add(i+1);
            }else{
                continue;
            }
        }
        
        int[] answer = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}