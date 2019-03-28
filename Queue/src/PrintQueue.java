import java.util.*;

public class PrintQueue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=0;i<num;i++) {
			int papers = sc.nextInt();
			int index = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			int[] arr = new int[papers];
			for(int j=0;j<papers;j++) {
				int n = sc.nextInt();
				q.offer(n);	
				arr[j] = n;
			}
			Arrays.sort(arr);
			
			int pri_index = arr.length-1;
			int count = 0;
			
			while(true) {
				int tmp = q.poll();
				
				if(tmp == arr[pri_index]) {
					count++;
					pri_index--;
					if(index == 0)
						break;
					else
						index--;
				}else {
					q.offer(tmp);
					/*여기 부분 잘 이해하기 ! 기억하기 !*/
					index = (index==0)?q.size()-1:--index;
				}
			}
			System.out.println(count);
		}
	}

}
