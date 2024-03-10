import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution{
	public static void main(String args[]) throws Exception{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < 10; i++) { // 테스트 케이스 10회 수행.
			int N = Integer.parseInt(rd.readLine()); // 덤프 횟수 정수 입력받기
			String input = rd.readLine(); // 상자의 높이값 입력받기
			String[] str = input.split(" ");
			int[] box = new int[100]; // 상자의 높이값을 저장할 배열 box 생성
			for (int k = 0; k < str.length; k++) {
				box[k] = Integer.parseInt(str[k]); // 상자의 높이값을 box 배열에 입력
			}
			Arrays.sort(box);
			// 덤프 수행
			for (int k = 0; k < N; k++) {
				if (box[99] - box[0] <= 1)
					break;
				box[99]--;
				box[0]++;
				Arrays.sort(box);
			}
			// 결과 저장
			result.add(box[99] - box[0]);
		}
		for (int i = 0; i < 10; i++)
			System.out.printf("#%d %d\n", i + 1, result.get(i));
	}
}