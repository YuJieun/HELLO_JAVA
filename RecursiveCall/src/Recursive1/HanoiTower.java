package Recursive1;
import java.math.BigInteger;
import java.util.Scanner;

public class HanoiTower {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger bi = new BigInteger("2");
        //2�� n���� -1
        BigInteger c = bi.pow(n).subtract(BigInteger.ONE);
        //Ƚ�� ���
        System.out.println(c);
        if (n <= 20)
            hanoi(n, 1, 2, 3);
        
    }
	
	static void hanoi(int n, int start, int mid, int end) { 
        //n : �����ǰ���, start : ���۸����ȣ mid : ¡�˴ٸ� ���� ��ȣ end : �����������ȣ
        if (n == 1) {
            System.out.println(start+" "+end);
            return;
        }
 
        hanoi(n - 1, start, end, mid); 
        //1������ : n-1�� ������ ���۸��뿡�� ���� ���븦 ���� �߰������
        System.out.println(start+" "+end);
        //2������ : ���۸����� ������ ���� 1�� ������ ������ �����
        hanoi(n - 1, mid, start, end);
        //3������ : �߰������ �Ű�� n-1�� ������ �ٽ� ������ ����� �̵�.
        return;
    }
 
}
