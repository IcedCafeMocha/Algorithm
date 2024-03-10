import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < 10; i++) { // 10회 테스트 수행.
			int N = Integer.parseInt(br.readLine()); // 테스트 케이스의 길이 N 입력받기.
			String str = br.readLine(); // 문자열 입력받기.
			int cnt = 0;
			for (int k = 0; k < N; k++) {
				char c = str.charAt(k);
				// 문자 c가 여는 괄호면 cnt에 해당 값을 더한다.
				if (c == '(')
					cnt+=1;
				else if (c == '{')
					cnt+=2;
				else if (c == '[')
					cnt+=3;
				else if (c == '<')
					cnt+=4;
				// 문자 c가 닫는 괄호면 cnt에서 해당 값을 뺀다.
				else if (c == ')')
					cnt-=1;
				else if (c == '}')
					cnt-=2;
				else if (c == ']')
					cnt-=3;
				else
					cnt-=4;
			}
			if (cnt == 0) // cnt 값이 0이면 유효한 문자열으로 판별, result 리스트에 1 저장.
				result.add(1);
			else // cnt 값이 0이 아니면 유효하지 않은 문자열으로 판별, result 리스트에 0 저장.
				result.add(0);

		}
		for (int i = 0; i < 10; i++)
			System.out.printf("#%d %d\n", i + 1, result.get(i)); // 저장된 결과값 출력.
	}
}