import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input;
		long cnt = 0;

		// 필요 데이터 입력
		// 시험장의 개수 N
		int N = Integer.parseInt(br.readLine());

		// 각 시험장에 있는 응시자의 수
		input = br.readLine().split(" ");
		int[] apl = new int[N];
		for (int i = 0; i < N; i++)
			apl[i] = Integer.parseInt(input[i]);

		// 총감독관이 감시할 수 있는 수 B와 부감독관의 수 C
		input = br.readLine().split(" ");
		int B = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);

		for (int i = 0; i < N; i++) {
			if (apl[i] > B) {
				if ((apl[i] - B) % C == 0) {
					cnt += 1 + (apl[i] - B) / C;
				} else {
					cnt += 1 + ((apl[i] - B) / C) + 1;
				}
			} else {
				cnt += 1;
			}
		}
		bw.write(Long.toString(cnt));
		bw.flush();
		bw.close();
	}
}