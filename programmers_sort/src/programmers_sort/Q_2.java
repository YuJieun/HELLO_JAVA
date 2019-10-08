package programmers_sort;

import java.util.*;

class Q_2 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str_arr = new String[numbers.length];
        for(int i=0 ;i<numbers.length; i++){
            str_arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(str_arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        for(int i=0; i<str_arr.length; i++){
            answer += str_arr[i];
        }
        
        if(str_arr[0].equals("0"))
            answer = "0";
        
        return answer;
    }
}