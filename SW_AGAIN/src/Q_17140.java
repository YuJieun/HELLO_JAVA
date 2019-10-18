import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Q_17140 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r=  sc.nextInt()-1;
		int c = sc.nextInt()-1;
		int k = sc.nextInt();
		
		int[][] map = new int[100][100];
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int time = 0;
		int now_i = 3;
		int now_j = 3;
		while(true) {
			if(map[r][c]==k) {
				System.out.print(time);
				return;
			}
			
			if(time>100) {
				System.out.print(-1);
				return;
			}
			HashMap<Integer,Integer> hash = new HashMap();
			if(now_i>=now_j) {
				//R연산
				int max = -1; 
				for(int i=0; i<now_i; i++) {
					hash.clear();
					for(int j=0; j<now_j; j++) {
						int val = map[i][j];
						if(val!=0) {
							hash.put(val, hash.getOrDefault(val, 0)+1);
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
					
					if(max<cnt)
						max = cnt;
				}	
				now_j = max;
			}else {
				//C연산	
				int max = -1;
				for(int j=0; j<now_j; j++) {
					hash.clear();
					for(int i=0; i<now_i; i++) {
						int val = map[i][j];
						if(val!=0) {
							hash.put(val, hash.getOrDefault(val, 0)+1);
						}
					}
					Iterator it = sortByValue(hash).iterator();
					for(int i=0; i<now_i; i++) {
						map[i][j] = 0;
					}
					
					int cnt = 0;
					while(it.hasNext()) {
						if(cnt>=100)
							break;
						int tmp = (int)it.next();
						map[cnt][j]=tmp;
						map[cnt+1][j]=hash.get(tmp);
						cnt+=2;
					}
					
					if(max<cnt)
						max = cnt;
				}	
				now_i = max;
			}
			time++;
		}
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
