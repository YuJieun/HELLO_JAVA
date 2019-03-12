
import java.util.*;
class apartment 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
        int[][] people = new int[15][15];

        for(int i = 0 ; i < 15 ; i++) {
            people[i][0] = 1;
            people[0][i] = i + 1;
        }
        
        for(int i = 1 ; i <= 14 ; i++) {
            for(int j = 1 ; j <= 14 ; j++) {
                people[i][j] = people[i-1][j] + people[i][j-1];
            }
        }
        
        int T = in.nextInt();
		int result[] =new int[T];
        for(int i = 0 ; i < T ; i++) {
            int k = in.nextInt();
            int n = in.nextInt() - 1;
			result[i] = people[k][n];
        }

		for(int i=0; i<T; i++){
			System.out.println(result[i]);
		}
	}
}
