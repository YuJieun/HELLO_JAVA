import java.util.*;
class countingsort
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] arr = new int[num];

		int max = -1;

		for (int i=0;i<num ;i++ )
		{
			arr[i] = in.nextInt();
			if(arr[i]>max)
				max = arr[i];
		}

        int[] aux = new int[num];
        int[] c = new int[max+1];
		// max+1**

		Arrays.fill(c,0);

		for (int i=0;i<num ;i++ )
		{
			c[arr[i]] += 1;
		}

		for (int i=1;i<c.length ;i++ )
		{
			c[i] += c[i-1];
		}

		for (int i=num-1;i>=0 ;i-- )
		{
			aux[--c[arr[i]]] = arr[i];
			
		}

		for (int i=0; i<num;i++ )
		{
			System.out.println(aux[i]);
		}
	}

}
