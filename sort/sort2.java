import java.util.*;


class sort2 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		String N = in.nextLine();

		int size = N.length();

		char[] arr = new char[size];

		for(int i=0;i<size;i++){
			arr[i] = N.charAt(i);
		}

		Arrays.sort(arr);

		for(int i=size-1;i>=0;i--){
			System.out.print(arr[i]);
		}

	}
}
