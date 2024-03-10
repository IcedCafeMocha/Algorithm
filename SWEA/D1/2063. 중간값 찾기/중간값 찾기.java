import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Solution{
	public static void main(String args[]) throws Exception{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(rd.readLine()); // 점수의 개수 N 입력받기
		String input = rd.readLine(); // 점수 입력받기
		String[] str = input.split(" ");
		int[] grade = new int[N]; // 점수를 저장할 배열 grade 생성
		for (int i = 0; i < str.length; i++) {
			grade[i] = Integer.parseInt(str[i]); // 점수를 grade 배열에 저장
		}
		// 카운팅 정렬
		int[] counter = new int[101];
		for (int i = 0; i < grade.length; i++) {
			counter[grade[i]]++;
		}
		for (int i = 1; i < counter.length; i++) {
			counter[i] = counter[i] + counter[i - 1];
		}
		int[] temp = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			counter[grade[i]]--;
			temp[counter[grade[i]]] = grade[i];
		}
		System.out.println(temp[N/2]);
	}
}