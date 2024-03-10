import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Queue<Integer>> result = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		int N;
		boolean s;
		for (int k = 0; k < 10; k++) {
			sc.nextInt(); // 테스트케이스 번호 입력받기
			for (int i = 0; i < 8; i++) {
				q.offer(sc.nextInt());
			}
			s = true;
			while (s == true) {
				// 사이클
				for (int i = 1; i < 6; i++) {
					if (q.peek() - i <= 0) {
						q.poll();
						q.offer(0);
						s = false;
						break;
					} else {
						N = q.poll() - i;
						q.offer(N);
					}
				}
			}
			System.out.printf("#%d", k + 1);
			for (int i = 0; i < 8; i++)
				System.out.print(" " + q.poll());
			System.out.println();

			q.clear();
		}
	}
}