import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q_15683 {
	static ArrayList<cctv> arr;
	static int[][] map;
	static int n,m;
	static int[][] map2;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		arr = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0 && map[i][j]!=6)
					arr.add(new cctv(i,j));
			}
		}
		int[] combi = new int[arr.size()];
		dfs(combi, 0, arr.size());
		System.out.print(min);
	}
	
	public static void dfs(int[] combi, int index, int len) {
		if(index== len) {
			//사각지대 계산하기
			watch(combi);
			return;
		}
		
		cctv tmp = arr.get(index);
		switch(map[tmp.i][tmp.j]) {
		case 1:
			for(int i=1; i<=4; i++) {
				combi[index] = i;
				dfs(combi, index+1, len);
			}
			break;
		case 2:
			for(int i=1; i<=2; i++) {
				combi[index] = i;
				dfs(combi,index+1,len);
			}
			break;
		case 3:
			for(int i=1; i<=4; i++) {
				combi[index] = i;
				dfs(combi, index+1, len);
			}
			break;
		case 4:
			for(int i=1; i<=4; i++) {
				combi[index] = i;
				dfs(combi, index+1, len);
			}
			break;
		case 5:
			combi[index] = 1;
			dfs(combi, index+1,len);
		}
	}
	
	public static void watch(int[] combi) {
		map2 = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map2[i][j] = map[i][j];
			}
		}
		
		for(int i=0; i<arr.size(); i++) {
			cctv tmp = arr.get(i);
			int rotate_num = combi[i];
			switch(map2[tmp.i][tmp.j]) {
			case 1:
				move(tmp.i, tmp.j, rotate_num);
				break;
			case 2:
				if(rotate_num==1) {
					move(tmp.i, tmp.j, 1);
					move(tmp.i, tmp.j,2);
				}else {
					move(tmp.i, tmp.j,3);
					move(tmp.i, tmp.j,4);
				}
				break;
			case 3:
				if(rotate_num == 1) {
					move(tmp.i, tmp.j, 3);
					move(tmp.i, tmp.j,1);
				}else if(rotate_num ==2) {
					move(tmp.i, tmp.j,1);
					move(tmp.i, tmp.j,4);
				}else if(rotate_num ==3) {
					move(tmp.i, tmp.j, 2);
					move(tmp.i, tmp.j,4);
				}else {
					move(tmp.i, tmp.j,2);
					move(tmp.i, tmp.j,3);
				}
				break;
			case 4:
				if(rotate_num ==1) {
					move(tmp.i, tmp.j,1);
					move(tmp.i, tmp.j,2);
					move(tmp.i, tmp.j,3);
				}else if(rotate_num==2) {
					move(tmp.i, tmp.j,1);
					move(tmp.i, tmp.j,3);
					move(tmp.i, tmp.j,4);
				}else if(rotate_num==3) {
					move(tmp.i, tmp.j,1);
					move(tmp.i, tmp.j,2);
					move(tmp.i, tmp.j,4);
				}else {
					move(tmp.i, tmp.j,2);
					move(tmp.i, tmp.j,3);
					move(tmp.i, tmp.j,4);
				}
				break;
			case 5:
				move(tmp.i, tmp.j,1);
				move(tmp.i, tmp.j,2);
				move(tmp.i, tmp.j,3);
				move(tmp.i, tmp.j,4);
			}	
		}
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map2[i][j] == 0)
					cnt++;
			}
		}
		min = Math.min(min,cnt);
	}
	
	public static void move(int i, int j, int dir) {
		if(dir==1) {
			for(int c= j+1; c<m; c++) {
				if(map2[i][c]==6)
					break;
				else if(map2[i][c]==0)
					map2[i][c] = -1;
				else 
					continue;
			}
		}else if(dir==2) {
			for(int c=j-1; c>=0; c--) {
				if(map2[i][c]==6)
					break;
				else if(map2[i][c]==0)
					map2[i][c] = -1;
				else 
					continue;
			}
		}else if(dir==3) {
			for(int r= i-1; r>=0; r--) {
				if(map2[r][j]==6)
					break;
				else if(map2[r][j]==0)
					map2[r][j] = -1;
				else
					continue;
			}
		}else {
			for(int r= i+1; r<n; r++) {
				if(map2[r][j]==6)
					break;
				else if(map2[r][j]==0)
					map2[r][j] = -1;
				else
					continue;
			}
		}
	}
}

class cctv{
	int i,j;
	public cctv(int i, int j) {
		this.i=i;
		this.j=j;
	}
}
