package programmers_Stack_Queue;

import java.util.*;

class Q_4 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> q = new LinkedList<Truck>();
        
        int now_weight = 0;
        int car_num=0;
        while(true){
            answer++;
            int len = q.size();
            for(int i=0; i<len; i++){
                Truck tmp = q.poll();
                int tmp_ride = tmp.ride+1;
                if(tmp_ride!=bridge_length){
                    q.offer(new Truck(tmp_ride,tmp.weight));
                }else{
                    now_weight -= tmp.weight;
                }
            }
            
            
            if(car_num <truck_weights.length){
                if(now_weight + truck_weights[car_num]<=weight){
                    now_weight += truck_weights[car_num];
                    q.offer(new Truck(0,truck_weights[car_num]));
                    car_num +=1;
                }
            }
            
            if(q.size()==0 && car_num == truck_weights.length)
                break;
        }
        
        return answer;
    }
}

class Truck{
    int ride;
    int weight;
    
    Truck(int r, int w){
        this.ride = r;
        this.weight = w;
    }
}