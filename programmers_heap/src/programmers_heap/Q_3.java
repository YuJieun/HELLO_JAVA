package programmers_heap;

import java.util.*;

class Q_3 {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<Job>();
        List<Job> list = new ArrayList<>();
        for(int i=0; i<jobs.length; i++){
            pq.offer(new Job(jobs[i][0],jobs[i][1]));
        }
        
        for (int i = 0; i < jobs.length; i++) {
            list.add(pq.poll());
        }
        
        int time = 0;
        int sum = 0;
        while (list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
                if (time>=list.get(i).start) {
                    time+=list.get(i).duration;
                    sum+=time-list.get(i).start;
                    list.remove(i);
                    break;
                }
                if (i == list.size()-1) time++;
            }
        }
        
        int answer = (sum/jobs.length);
        return answer;
    }
}

class Job implements Comparable<Job>{
    int start;
    int duration;
    
    public Job(int s, int d){
        this.start = s;
        this.duration = d;
    }
    
    //소요시간이 짧은 것 우선, 소요시간이 같다면 시작시간이 빠른게 우선
    @Override
    public int compareTo(Job o){
        if(this.duration<o.duration)
            return -1;
        else if(this.duration == o.duration){
            if(this.start<o.start)
                return -1;
            else return 1;
        }else
            return 1;
    }
}