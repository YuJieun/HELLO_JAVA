import java.util.*;
import java.io.*;
class statics
{
	public static void main(String[] args) 
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		int n=0;
		try{
			n = Integer.parseInt(bf.readLine());
		}catch(IOException e){
			e.printStackTrace();
		}

		int[] arr = new int[n];
		HashMap<Integer,Integer> countmap = new HashMap();

		int sum=0;
		for (int i=0; i<n ;i++ )
		{
			try{
				arr[i] = Integer.parseInt(bf.readLine());
			}catch(IOException e){
				e.printStackTrace();
			}
			sum += arr[i];
		}

		Arrays.sort(arr);

		for (int i=0;i<n ;i++ )
		{
			if (countmap.containsKey(arr[i])){
				int val = countmap.get(arr[i]);
				val = val+1;
				countmap.remove(arr[i]);
				countmap.put(arr[i],val);

			}else{
				countmap.put(arr[i],1);
			}
		}

		int average = (int)Math.round(sum*1.0/n);
		//**********여기 n-1/2 로 해야해 **************//
		int mid = arr[(n-1)/2];
		//******************************************//

		ArrayList<Integer> maxlist = new ArrayList<>();

		Map.Entry<Integer, Integer> max = null;
		for(Map.Entry<Integer, Integer> i:countmap.entrySet() )
		{

			if(max==null || i.getValue().compareTo(max.getValue())>0){
				maxlist.clear();
				maxlist.add(i.getKey());
				max = i;
			}
			else if(i.getValue().compareTo(max.getValue())==0){
				maxlist.add(i.getKey());
			}
		}

		
		int many = 0;
		Collections.sort(maxlist);
		if(maxlist.size()==1){
			many = maxlist.get(0);
		}else{
			many = maxlist.get(1);
		}

		//int many = max.getKey();
		int range = arr[n-1]-arr[0];

		System.out.println(average);
		System.out.println(mid);
		System.out.println(many);
		System.out.println(range);
	}
}
