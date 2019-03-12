import java.util.*;

class sort1
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int i = 0;
		
		int num[] = new int[N];

		while(i<N){
			int j = in.nextInt();
			if(Math.abs(j)<= 1000){
				num[i] = j;
				i = i+1;
			}
		}

		for (i=0;i<N; i++)
		{
			for (int j=i+1; j<N; j++)
			{
				if(num[j]<num[i]){
					int tmp = num[i];
					num[i] = num[j];
					num[j] = tmp;
				}
			}
		}

		for (i=0;i<N; i++)
		{
			System.out.println(num[i]);
		}

	}
}
