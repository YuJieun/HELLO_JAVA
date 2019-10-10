package programmers_DFS_BFS;

import java.util.*;

class Q_4 {
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        boolean[] use = new boolean[tickets.length];
        PriorityQueue<Object> q = new PriorityQueue<Object>();
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals("ICN"))
                q.offer(new Object(tickets[i][1],i));
        }
        answer[0] = "ICN";
        int cnt=1;
        
        while(!q.isEmpty()){
            Object airport = q.poll();
            q.clear();
            System.out.print(airport.des);
            answer[cnt++] = airport.des;
            use[airport.ticket_num] = true;
            for(int i=0; i<tickets.length; i++){
                if(use[i]==false && tickets[i][0].equals(airport.des)){
                    q.offer(new Object(tickets[i][1],i));
                }
            }     
        }    
        return answer;
    }
}

class Object implements Comparable<Object> {
    String des;
    int ticket_num;
    
    public Object(String d, int t){
        this.des = d;
        this.ticket_num = t;
    }
    
    @Override
    public int compareTo(Object target) {
        return this.des.compareTo(target.des);
    }
}