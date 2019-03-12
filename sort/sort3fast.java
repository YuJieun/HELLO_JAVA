import java.util.*;

class sort3fast
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();

		String[] arr = new String[num];
		for (int i=0;i<num ;i++ )
		{
			arr[i] = in.next();
		}

		Arrays.sort(arr, new Comparator<String>() {

			@Override

			public int compare(String o1, String o2) {


				return Integer.compare(o1.length(), o2.length());

			}

		});

		

		int j, len, len_temp;

		for(int i=0; i<num; i++) {

			len = arr[i].length();

			for(j=i+1; j<num; j++) {

				len_temp = arr[j].length();

				if(len != len_temp) break;

			}

			Arrays.sort(arr, i, j);

			i=j-1;

		}




		
		System.out.println(arr[0]);
		for(int i=1;i<num;i++){
			if(arr[i-1].equals(arr[i])){
				continue;
			}
			System.out.println(arr[i]);

		}
	}
}
