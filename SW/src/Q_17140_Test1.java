import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Q_17140_Test1 {
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
//		map = new ArrayList[100];
//		for(int i=0; i<map.length; i++) {
//			map[i] = new ArrayList<Integer>();
//		}
		map = new int[100][100];
		
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int row = 2;
		int col = 2;
		int while_cnt = 0;
		while(true) {
			if(while_cnt>100)
				break;
			if(map[r-1][c-1]==k)
				break;
			HashMap<Integer, Integer> hash = new HashMap<Integer,Integer>();
			if(row>=col) {
				/*r연산 수행 -> 행마다 정렬*/
				int max = Integer.MIN_VALUE;
				for(int i=0;i<=row;i++) {
					for(int j=0;j<=col;j++) {
						if(map[i][j]==0)
							continue;
						if(hash.containsKey(map[i][j])) {
							int tmp = hash.get(map[i][j]);
							hash.remove(map[i][j]);
							hash.put(map[i][j], tmp+1);
						}else {
							hash.put(map[i][j],1);
						}
					}
					Iterator it = sortByValue(hash).iterator();
					Arrays.fill(map[i], 0);
					
					int cnt = 0;
					while(it.hasNext()) {
						if(cnt>=100)
							break;
						int tmp = (int)it.next();
						map[i][cnt]=tmp;
						map[i][cnt+1]=hash.get(tmp);
						cnt+=2;
					}
					if(max< cnt-1)
						max = cnt-1;
					hash.clear();
				}	
				col = max;
			}else {
				int max = Integer.MIN_VALUE;
				/*c연산 수행 -> 열마다 정렬*/
				for(int j=0;j<=col;j++) {
					for(int i=0;i<=row;i++) {
						if(map[i][j]==0)
							continue;
						if(hash.containsKey(map[i][j])) {
							int tmp = hash.get(map[i][j]);
							hash.remove(map[i][j]);
							hash.put(map[i][j], tmp+1);
						}else {
							hash.put(map[i][j],1);
						}
					}
					Iterator it = sortByValue(hash).iterator();
										
					for(int i=0; i<=row ; i++) {
						map[i][j] = 0;
					}
					
					int cnt = 0;
					while(it.hasNext()) {
						if(cnt>=100)
							break;
						int tmp = (int)it.next();
						map[cnt][j] = tmp;
						map[cnt+1][j] = hash.get(tmp);
						cnt+=2;
						
					}
					if(max<cnt-1)
						max = cnt-1;
					hash.clear();

				}
				row =  max;
			}
			while_cnt +=1;
		}
		
		if(while_cnt>100)
			System.out.println(-1);
		else
			System.out.println(while_cnt);
	}
	
	public static List sortByValue(HashMap hash) {
		ArrayList<Integer> list = new ArrayList();
		list.addAll(hash.keySet());
		
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				Object v1 = hash.get(o1);
				Object v2 = hash.get(o2);
				if(v1==v2) {
					return ((Comparable)o1).compareTo(o2);
				}else {
				return((Comparable)v1).compareTo(v2);}
			}
		});
		return list;
	}

}
