package Recursive1;
import java.math.BigInteger;
import java.util.Scanner;

public class HanoiTower {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger bi = new BigInteger("2");
        //2의 n제곱 -1
        BigInteger c = bi.pow(n).subtract(BigInteger.ONE);
        //횟수 출력
        System.out.println(c);
        if (n <= 20)
            hanoi(n, 1, 2, 3);
        
    }
	
	static void hanoi(int n, int start, int mid, int end) { 
        //n : 원판의개수, start : 시작막대번호 mid : 징검다리 막대 번호 end : 도착지막대번호
        if (n == 1) {
            System.out.println(start+" "+end);
            return;
        }
 
        hanoi(n - 1, start, end, mid); 
        //1번과정 : n-1개 원판을 시작막대에서 도착 막대를 거쳐 중간막대로
        System.out.println(start+" "+end);
        //2번과정 : 시작막대의 마지막 남은 1개 원판을 도착지 막대로
        hanoi(n - 1, mid, start, end);
        //3번과정 : 중간막대로 옮겼던 n-1개 원판을 다시 도착지 막대로 이동.
        return;
    }
 
}
