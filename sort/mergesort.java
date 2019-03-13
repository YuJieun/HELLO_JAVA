import java.util.*;

class mergesort 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] arr = new int[n];

		for (int i=0;i<n ;i++ )
		{
			arr[i] = in.nextInt();
		}

		mergesort(arr);

		for (int i=0;i<n ;i++ )
		{
			System.out.println(arr[i]);
		}
	}

	public static void mergesort(int[] arr){
		if(arr.length==1)
			return;

		int[] s1 = new int[arr.length/2];
		int[] s2 = new int[arr.length-arr.length/2];

		for (int i=0;i<arr.length/2 ;i++ )
		{
			s1[i] = arr[i];
		}

		for (int i=0;i<arr.length-arr.length/2 ;i++ )
		{
			s2[i] = arr[i+arr.length/2];
		}

		mergesort(s1);
		mergesort(s2);

		merge(s1,s2,arr);
	}

	public static void merge(int[] s1, int[] s2, int[] arr){
		int n1=0,n2=0,n3=0;

		while(n1<s1.length && n2<s2.length){
			if(s1[n1]<s2[n2]){
				arr[n3] = s1[n1];
				n1++;
			}else{
				arr[n3] = s2[n2];
				n2++;
			}
			n3++;
		}

		while(n1<s1.length){
			arr[n3] = s1[n1];
			n1++;
			n3++;
		}

		while(n2<s2.length){
			arr[n3] = s2[n2];
			n2++;
			n3++;
		}
	}
}



