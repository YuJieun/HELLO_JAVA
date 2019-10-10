package programmers_DFS_BFS;

import java.util.*;

class Q_4 {
    boolean[] visited;
    String tmp="";
    ArrayList<String> arr = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer ={};
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                visited = new boolean[tickets.length];
                tmp = "ICN";
                visited[i] = true;
                dfs(tickets[i][1],tickets, 1);
            }
        }
        Collections.sort(arr);
        answer = arr.get(0).split(",");
        return answer;
    }
    
    public void dfs(String airport, String[][] tickets, int cnt){
        tmp = tmp +","+airport+"";
        if(cnt==tickets.length){
            arr.add(tmp);
            return;
        }
        for(int j=0; j<tickets.length; j++){
            if(visited[j]==false && airport.equals(tickets[j][0])){
                visited[j] = true;
                dfs(tickets[j][1],tickets,cnt+1);
                visited[j] = false;
                tmp = tmp.substring(0, tmp.length()-4);
            }
        }
    }
}
