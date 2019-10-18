import java.util.ArrayList;
import java.util.Scanner;

public class Q_17143 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int m = sc.nextInt();
		
		Shark[][] map = new Shark[r+1][c+1];
		
		for(int i=0; i<m;i++) {
			int tmp_r = sc.nextInt();
			int tmp_c = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			int z = sc.nextInt();
			map[tmp_r][tmp_c] = new Shark(s,d,z);
		}
		
		int sum = 0;
		for(int i=0; i<c; i++) {
			Shark[][] map2 = new Shark[r+1][c+1];
			//오른쪽으로 한칸 이동
			
			//땅과 제일 가까운 상어 잡음.
			for(int k=1; k<=r; k++) {
				if(map[k][i+1]!=null) {
					Shark tmp = map[k][i+1];
					sum += tmp.z;
					map[k][i+1]=null;
					break;
				}
			}
			
			//상어이동
			for(int k=1; k<=r; k++) {
				for(int l=1; l<=c; l++) {
					if(map[k][l]!=null) {
						Shark tmp = map[k][l];
						int new_row = k;
						int new_col = l;
						int dir = tmp.dir;
						int speed = tmp.speed;
						int size = tmp.z;
						
						if(dir==1) {
							int pos = k;
							int op = -1;
							for(int s=0; s<speed; s++) {
								if(pos+(1*op)>r || pos+(1*op)<=0) {
									op = op*(-1);
								}
								pos = pos+(1*op);
							}
							if(op==1)
								tmp.setDir(2);
							new_row = pos;
						}
						else if(dir==2) {
							int pos = k;
							int op = 1;
							for(int s=0; s<speed; s++) {
								if(pos+(1*op)>r || pos+(1*op)<=0) {
									op = op*(-1);
								}
								pos = pos+(1*op);				
							}
							if(op==-1)
								tmp.setDir(1);
							new_row = pos;
						}else if(dir ==3) {
							int pos = l;
							int op = 1;
							for(int s=0; s<speed; s++) {
								if(pos+(1*op)>c || pos+(1*op)<=0) {
									op = op*(-1);
								}
								pos = pos+(1*op);
							}
							if(op==-1)
								tmp.setDir(4);
							new_col = pos;
						}else {
							int pos = l;
							int op = -1;
							for(int s=0; s<speed; s++) {
								if(pos+(1*op)>c || pos+(1*op)<=0) {
									op = op*(-1);
								}
								pos = pos+(1*op);
							}
							if(op==1)
								tmp.setDir(3);
							new_col = pos;
						}
						
						if(map2[new_row][new_col]!=null) {
							Shark origin = map2[new_row][new_col];
							if(origin.z>size)
								continue;
							else if(origin.z<size)
								map2[new_row][new_col] = tmp;
						}else {
							map2[new_row][new_col] = tmp;
						}
					}
				}
			}
			
			for(int k=1; k<=r; k++) {
				for(int l=1; l<=c ;l++) {
					map[k][l] = map2[k][l];
				}
			}
		}
		
		System.out.print(sum);

	}

}
class Shark{
	int speed,dir,z;
	public Shark(int s, int d, int z) {
//		this.r= r;
//		this.c= c;
		this.speed = s;
		this.dir= d;
		this.z = z;
	}
	
	public void setDir(int d) {
		this.dir = d;
	}
}
