import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q_3 {
	static int max = -1;
	static int[] map;
	static int flag=0;
	static int count = 0;
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        map = new int[size];
        for (int i = 0; i < size; i++) {
            map[i] = scanner.nextInt();
        }
	            
    	//삼
    	DFS(1,(-1)*map[0],1,0);
    	
    	//안삼
    	DFS(1,0,0,0);
    	
    	System.out.println(max);
	}
	
	public static void DFS(int index, int profit, int flag, int count) {
		if(index == map.length) {
			if(max < profit)
				max = profit;
			return;
		}
		else {
			if(flag==1) {
				//팔기
				DFS(index+1, profit+map[index],0,count+1);
				
				//팔지 않고 하루 가지기
				DFS(index+1, profit,1,count);
			}
			else {
				//금을 판 날과 다음날에는 금을 사지 않음
				if(count==1) {
					DFS(index+1,profit,0,count+1);
				}
				else {
					DFS(index+1,profit-map[index],1,0);
					DFS(index+1,profit,0,0);
				}
			}	
		}
	}
}
