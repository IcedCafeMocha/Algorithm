import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 학생 수 N
		int N = Integer.parseInt(st.nextToken());
		// 한 방의 최대 인원 수 K
		int K = Integer.parseInt(st.nextToken());

		// 학생 수를 셀 배열 생성
		// 남학생 배열
		int[] male = new int[7];
		// 여학생 배열
		int[] female = new int[7];

		// 성별을 구분하고, 각 학년의 학생 수 카운팅
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("1"))
				male[Integer.parseInt(st.nextToken())]++;
			else
				female[Integer.parseInt(st.nextToken())]++;
		}

		// 필요한 방의 최솟값 찾기
		// 최대 인원 수 K가 넘는 학년은 여러 방으로 나눠준다.
		int room = 0;
		// 남학생 수 검사
		for (int grade = 1; grade <= 6; grade++) {
			if (male[grade] != 0) {
				if (male[grade] > K) {
					if (male[grade] % K == 0)
						room += male[grade] / K;
					else
						room += male[grade] / K + 1;
				} else {
					room++;
				}
			} else
				continue;
		}
		// 여학생 수 검사
		for (int grade = 1; grade <= 6; grade++) {
			if (female[grade] != 0) {
				if (female[grade] > K) {
					if (female[grade] % K == 0)
						room += female[grade] / K;
					else
						room += female[grade] / K + 1;
				} else {
					room++;
				}
			} else
				continue;
		}
		bw.write(String.valueOf(room));
		bw.flush();
		bw.close();

	}
}
