import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class habanki_14890 {

	/*미완성 ㅠ 너무 어렵단*/
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][n];
		boolean[][] slope = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int k;
		int cnt = 0;
		int check = 0;
		int pre = 0;
		boolean flag = false;
		int j;
		//가로로 경사로 놓기
		for(int i=0;i<n;i++) {
			check=0;
			pre = 0;
			flag = false;
			for(j=0;j<n;j++) {
				//첫번째 블록일때
				if(j==0) {
					pre = arr[i][j];
					check++;
					continue;
				}
				
				//flag가 켜져있는경우 check가 l만큼이어야 통과 가능
				if(flag==true) {
					if(check == l) {
						flag = false;
						pre = arr[i][j];					
						for(k=0;k<l;k++)
							slope[i][j-k-1] = true;
						check = 1;
						continue;
					}
					else if(pre == arr[i][j]) {
						check++;
						if(check == l) {
							flag = false;
							for(k=0;k<l;k++)
								slope[i][j-k] = true;
							check = 1;
							continue;
						}
					}else {
						if(check == l) {
							pre = arr[i][j];
							flag = false;
							for(k=0;k<l;k++)
								slope[i][j-k] = true;
							check = 1;
							continue;
						}else {
							flag =false;
							break;
						}
					}
				
				}
				
				//이전블록이랑 숫자 같을때
				if(pre==arr[i][j]) {
					check++;
					continue;
				}
				
				//이전블록 숫자보다 작을때
				if(pre>arr[i][j]) {
					if(pre-1==arr[i][j] && j+l<=n) {
						for(k=0;k<l;k++) {
							if(slope[i][j+k] == true) {
								break;
							}
						}
						if(k!=l)
							break;
						//개수세는 flag검사 ON
						flag = true;
						pre = arr[i][j];
						check = 1;
					}else {
						break;
					}
				}
				
				//이전 블록 숫자보다 클때
				if(pre<arr[i][j]) {
					if(pre+1==arr[i][j] && check>=l) {
						//경사로 놓기
						
						for(k=1;k<=l;k++) {
							if(slope[i][j-k] == true) {
								break;
							}
						}
						if(k!=l+1)
							break;
						
						for(k=1;k<=l;k++)
							slope[i][j-k] = true;

						pre = arr[i][j];
						check = 1;
					}
					else {
						break;
					}
				}
			}
			System.out.println(j);
			if(j==6)
				cnt++;
		}
		
		for(int i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				System.out.print(slope[i][j]);
			}
			System.out.println();
		}
		
		System.out.println(cnt);
	
	}
}
