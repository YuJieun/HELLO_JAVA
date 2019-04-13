import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test1 {
	static int[][] puzzle;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		for (int num = 0; num < n; num++) {
			puzzle = new int[9][9];
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			checkPuzzle();
		}
	}

	public static void checkPuzzle() {
		int[] arr = new int[10];

		/* 열 체크 */
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[puzzle[i][j]]++;
			}
			if (!checkRule(arr)) {
				System.out.println("NO");
				return;
			}
			Arrays.fill(arr, 0);
		}

		/* 행 체크 */
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				arr[puzzle[i][j]]++;
			}
			if (!checkRule(arr)) {
				System.out.println("NO");
				return;
			}
			Arrays.fill(arr, 0);
		}
		
		
		/* 3x3칸 체크*/
		for(int num=0;num<9;num++) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					arr[puzzle[(num/3)*3+i][(num%3)*3+j]]++;
				}
			}
			if (!checkRule(arr)) {
				System.out.println("NO");
				return;
			}
			Arrays.fill(arr, 0);
		}
		System.out.println("YES");
		return;

	}

	public static boolean checkRule(int[] arr) {
		for (int i = 1; i < 10; i++) {
			if (arr[i] != 1)
				return false;
		}
		return true;
	}

}
