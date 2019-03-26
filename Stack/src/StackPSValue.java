import java.util.*;
import java.io.*;

public class StackPSValue{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack<Character>();
		String tmp = br.readLine();
		int sum = 0;
		int cnt = 1;
		boolean flag = true;
		for(int i=0;i<tmp.length();i++) {
			char c = tmp.charAt(i);
			if(c=='(') {
				cnt *= 2;
				st.push('(');
				if(i+1<tmp.length()&&tmp.charAt(i+1)==')')
					sum += cnt;
			}else if(c=='[') {
				cnt *= 3;
				st.push('[');
				if(i+1<tmp.length()&&tmp.charAt(i+1)==']')
					sum += cnt;
			}else if(c==')') {
				if(st.empty()) {
					System.out.println(0);
					flag = false;
					break;
				}
				else {
					if(st.peek()=='[') {
						System.out.println(0);
						flag = false;
						break;
					}
					else {
						st.pop();
						cnt /=2;
					}
				}
			}else {
				if(st.empty()) {
					System.out.println(0);
					flag = false;
					break;
				}
				else {
					if(st.peek()=='(') {
						System.out.println(0);
						flag = false;
						break;
					}
					else {
						st.pop();
						cnt /=3;
					}
				}
			}
		}
		if(!st.empty()&&flag) {
			System.out.println(0);
		}
		else if(flag) {
			System.out.println(sum);
		}

	}
}
