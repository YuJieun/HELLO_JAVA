package programmers_DFS_BFS;

import java.util.*;

class Q_2 {
    boolean[] visited;
    int answer=0;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(visited[i]==false){
                go(i,computers);
                answer++;
            }
        }        
        return answer;
    }
    
    public void go(int idx, int[][] computers){
        visited[idx]= true;
        for(int j=0; j<visited.length; j++){
            if(visited[j]==false && computers[idx][j]==1){
                go(j, computers);
            }
        }
        return;
    }
}
