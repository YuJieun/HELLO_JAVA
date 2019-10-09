package programmers_Stack_Queue;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Work> q = new LinkedList<Work>();
        for(int i=0; i<progresses.length; i++){
            q.offer(new Work(progresses[i],speeds[i]));
        }

        while(true){
            boolean flag = true;
            int cnt = 0;
            int len = q.size();
            System.out.print("dd");
            for(int i=0; i<len; i++){
                System.out.print("hh");
                Work tmp = q.poll();
                int new_progress = tmp.progress + tmp.speed;
                System.out.print(new_progress);
                if(new_progress>=100 && flag == true){
                    System.out.print("qq");
                    cnt++;
                }else{
                    flag = false;
                    q.offer(new Work(new_progress,tmp.speed));
                }
            }
            System.out.println();
            if(cnt >0)
                arr.add(cnt);
            if(q.size()==0)
                break;
        }

        int[] answer = new int[arr.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = arr.get(i);
            System.out.print(answer[i]);
        }

        return answer;
    }
}

class Work{
    int progress;
    int speed;

    Work(int p, int s){
        this.progress = p;
        this.speed = s;
    }
}