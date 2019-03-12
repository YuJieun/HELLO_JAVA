import java.util.*;

class sort3 
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
		String tmp;
		for (int i=1;i<num ;i++ )
		{	
			for (int j=0; j<i;j++ )
			{
				if(arr[i].equals(arr[j])){
					tmp = arr[i];
					arr[i] = arr[j+1];
					arr[j+1]= tmp;
				}
				else if(arr[i].length()<arr[j].length()){
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
				else if(arr[i].length()==arr[j].length()){
					if(arr[i].compareTo(arr[j])<0){
						tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
					}
				}
			}
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
