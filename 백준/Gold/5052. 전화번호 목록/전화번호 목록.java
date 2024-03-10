import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 테스트케이스 개수 t
		int t = Integer.parseInt(br.readLine());
		// t만큼 테스트 수행
		int n;
		// 입력받을 전화번호 문자열을 저장할 리스트 생성
		List<String> list = new ArrayList<>();
		test: for (int testcase = 0; testcase < t; testcase++) {
			list.clear();
			// 전화번호의 수 n
			n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				list.add(br.readLine());
			}
			// 정렬
			Collections.sort(list);
			// 다른 전화번호를 접두어로 갖고 있는 번호가 있는지 확인
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i + 1).startsWith(list.get(i)) == true) {
					bw.write("NO");
					bw.newLine();
					continue test;
				}
			}
			bw.write("YES");
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
