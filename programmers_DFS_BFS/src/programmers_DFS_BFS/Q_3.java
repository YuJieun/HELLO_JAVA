package programmers_DFS_BFS;

import java.util.*;

class Q_3 {
    boolean[] visited;
    int min = Integer.MAX_VALUE;
    int len;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        len = begin.length();
        boolean flag = false;
        for(String tmp : words){
            if(tmp.equals(target))
                flag = true;
        }
        if(!flag)
            return 0;
        
        dfs(begin,0,words, target);
        return min;
    }
    
    public void dfs(String word, int cnt, String[] words, String target){
        if(word.equals(target)){
            if(cnt<min)
                min = cnt;
            return;
        }
        for(int i=0; i<words.length; i++){
            if(visited[i]==false){
                int check = 0;
                for(int j=0; j<len; j++){
                    if(words[i].charAt(j)!= word.charAt(j))
                        check++;
                }
                if(check==1){
                    visited[i] = true;
                    dfs(words[i],cnt+1,words,target);
                    visited[i] = false;
                }
            }
        }
    }
}