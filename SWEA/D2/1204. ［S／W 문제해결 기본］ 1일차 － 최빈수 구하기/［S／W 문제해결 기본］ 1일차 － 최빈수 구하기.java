import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
class Solution{
	public static void main(String args[]) throws Exception{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> result = new ArrayList<>(); // 결과값을 저장할 리스트 생성
		int T = Integer.parseInt(rd.readLine()); // 테스트 케이스 횟수 T 입력받기
		for (int i = 0; i < T; i++) { // 테스트 케이스 T회 수행.
			rd.readLine();
			String input = rd.readLine(); // 학생 1000명의 수학 점수 입력받기
			String[] str = input.split(" ");
			int[] grade = new int[1000]; // 점수를 저장할 배열 grade 생성
			for (int k = 0; k < str.length; k++) {
				grade[k] = Integer.parseInt(str[k]); // 점수를 grade 배열에 저장
			}
			// 최빈수 구하기
			int[] counter = new int[101]; // 0점~100점의 횟수를 세서 저장할 배열 생성
			for (int k = 0; k < grade.length; k++)
				counter[grade[k]]++;
			int MAX = 0;
			for (int k = 0; k < counter.length; k++) {
				if (counter[MAX] <= counter[k])
					MAX = k;
			}
			result.add(MAX);
		}
		for (int i = 0; i < T; i++)
			System.out.printf("#%d %d\n", i + 1, result.get(i));
	}
}