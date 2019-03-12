import java.util.Scanner;
public class warmingup  
{
	public static void main(String[] args) 
	{
		//입력받기
		int Area;

		System.out.print("밑변과 높이의 길이를 입력해주세요: ");
		Scanner input1 = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);

		int Base = input1.nextInt();
		int Height = input2.nextInt();

		Area = Base * Height *1/2;

		System.out.println("Area of TRiangle is "+Area);

		System.out.println(add(3,5));
		System.out.println(sub(10,3));

		int[] i_array = new int[8];
		//또는
		int[] i_array2 = {1,2,3,4,5,6,7,8};
		System.out.println(i_array2[5]);

	}

	public static int add(int a , int b){
		return a+b;
	}

	public static int sub(int a, int b){
		return a-b;
	}
}
