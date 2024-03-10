import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
class Solution{
	public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
		List<Integer> result = new ArrayList<>();
		int[][] ary = new int[100][100]; // 입력받을 배열 생성
		int r, c;
		for (int T = 0; T < 10; T++) { // 테스트 10회 수행
			sc.next();
			for (r = 0; r < 100; r++) // ary 배열에 필요한 값 입력받기.
				for (c = 0; c < 100; c++)
					ary[r][c] = sc.nextInt();

			List<Integer> tmp = new ArrayList<>();
			int sum = 0;
			for (r = 0; r < 100; r++) { // 각 행의 합
				for (c = 0; c < 100; c++) {
					sum += ary[r][c];
				}
				tmp.add(sum);
				sum = 0;
			}
			for (c = 0; c < 100; c++) { // 각 열의 합
				for (r = 0; r < 100; r++) {
					sum += ary[r][c];
				}
				tmp.add(sum);
				sum = 0;
			}
			r = 0;
			c = 0;
			while (true) { // 대각선의 합
				sum += ary[r][c];
				r++;
				c++;
				if (r > 99 && c > 99) {
					tmp.add(sum);
					sum = 0;
					break;
				}
			}
			r = 0;
			c = 99;
			while (true) { // 대각선의 합
				sum += ary[r][c];
				r++;
				c--;
				if (r > 99 && c < 0) {
					tmp.add(sum);
					sum = 0;
					break;
				}
			}
			// 최대값 구해서 result 리스트에 저장
			int[] tmp2 = new int[tmp.size()];
			for (int k = 0; k < tmp.size(); k++)
				tmp2[k] = tmp.get(k);
			Arrays.sort(tmp2);
			result.add(tmp2[tmp2.length - 1]);
		}

		// 결과 출력
		for (int i = 0; i < 10; i++)
			System.out.printf("#%d %d\n", i+1, result.get(i));
	}
}