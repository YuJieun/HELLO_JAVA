import java.util.*;
public class Q_14501 {

	/* �̰� DP�̴�. 
	 * ���� �����ϱ�
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		int[] t = new int[n+10];
		int[] p = new int[n+10];
		int[] dp = new int[n+10];
		
		for(int i=1;i<=n;i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		for(int i=1;i<=n+1;i++) {
			//�������� ������ �ȵǴϱ� max������ ����. �׷��� �̹� max���� ū ������ ä���� �ִ°��,
			//�װ� ����.
			dp[i] = Math.max(dp[i],max);
			//���� ���� ������ ���� �������ֱ�. �׷��� �̹� �� ū �������� ä���� �ִ� ��쿡�� �״�� ���α�
			dp[t[i]+i] = Math.max(dp[t[i]+i],p[i]+dp[i]);
			//�ִ� �������ֱ�. ������ max�� ���� dp�߿�...
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
		
	}

}
