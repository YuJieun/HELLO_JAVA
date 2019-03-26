import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class StackPS {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Stack<Character> st = new Stack<Character>();
		int i,j;
		boolean flag=true;
		for(i=0; i<num;i++) {
			String tmp = br.readLine();
			for(j=0;j<tmp.length();j++) {
				if(tmp.charAt(j)=='(') {
					st.push('(');
				}
				else {
					if(st.empty()) {
						//스택 빈지 아닌지 체크
						flag = false;
					}else {
						st.pop();
					}
				}
			}
			if(!st.empty()||flag==false)
				System.out.println("NO");
			else if(flag == true)
				System.out.println("YES");
			flag = true;
			st.clear();
		}
		
	}

}
