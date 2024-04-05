import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] bills = { 1, 5, 10, 50, 100, 500, 1000, 5000 };
		int[] count = new int[8];
		int N;
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			// 거슬러 주어야 할 금액 N
			N = Integer.parseInt(br.readLine()) / 10;
			for (int i = 7; i >= 0; i--) {
				count[i] = N / bills[i];
				N = N % bills[i];
			}
			System.out.println("#" + testcase);
			for (int i = 7; i >= 0; i--)
				System.out.print(count[i]+" ");
            System.out.println();
		}
	}
}