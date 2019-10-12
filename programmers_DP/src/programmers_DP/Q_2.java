package programmers_DP;

import java.util.*;

class Q_2 {
    public long solution(int N) {
        //1번풀이 (시간초과)
        long[] arr = new long[N+1];
        long answer = 4;
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2; i<arr.length; i++){
            arr[i] = arr[i-1]+ arr[i-2];
        }
        answer = arr[N]*2 + (arr[N-1]+arr[N])*2;
        return answer;
    }
}