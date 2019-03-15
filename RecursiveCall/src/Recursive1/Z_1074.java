package Recursive1;
import java.util.*;


public class Z_1074 {
	static int n,r,c;
	static int count=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		//시작점과 size를 준다.
		search(0,0,(int)Math.pow(2,n));
	}
	
	static void search(int x, int y, int size) {
		
		if(size==1) {
			if(x==r&&y==c) {
				System.out.println(count);
			}
			count++;
			return;	
		}
		
		int s = size/2;
		
		search(x,y,s);
		search(x,y+s,s);
		search(x+s,y,s);
		search(x+s,y+s,s);
    }
}
