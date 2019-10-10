package programmers_DFS_BFS;

import java.util.*;

class Q_1 {
    static int cnt=0;
    static int len, target_num;
    static int[] arr;
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        target_num = target;
        arr = new int[len];
        for(int i=0; i<len; i++){
            arr[i] = numbers[i];
        }
        go(arr[0],0);
        go((-1)*arr[0],0);
        return cnt;
    }
    
    public void go(int num, int index){
        if(index+1 == len){
            if(num == target_num)
                cnt++;
            return;
        }else{
            go(num+arr[index+1],index+1);
            go(num-arr[index+1],index+1);
        }
    }
}