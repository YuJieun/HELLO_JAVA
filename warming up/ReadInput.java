import java.io.*;

class ReadInput
{
	public static void main(String[] args) 
	{
		try{
			File file = new File("C:\\Users\\sm-pc\\hellojava\\HELLO_JAVA\\sort\\sample1.txt");
			File file_w = new File("C:\\Users\\sm-pc\\hellojava\\HELLO_JAVA\\sort\\sample2.txt");

			FileReader filereader = new FileReader(file);
			int ch = 0;

			/* 한글자씩 받기 */
			while((ch = filereader.read()) != -1){
				System.out.print((char)ch);
				if((char)ch =='\n')
					System.out.println("enter");
			}

			/* 한줄씩 받기 */
			BufferedReader bufreader = new BufferedReader(filereader);
			String line ="";
			while((line = bufreader.readLine()) != null){
				System.out.println(line);
			}
			bufreader.close();
			filereader.close();


			/* 파일 쓰기 */
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_w));
			if(file_w.isFile() && file_w.canWrite()){
				bufferedWriter.write("ohoh");
				bufferedWriter.newLine();
				bufferedWriter.write("ohoh");
				bufferedWriter.close();
			}

		}catch(FileNotFoundException e){

		}catch(IOException e){
			System.out.println(e);
		}
	}
}
