import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		String[] input;
		int N, D, cnt;
		boolean[] map;

		for (int testcase = 1; testcase < T + 1; testcase++) {
			input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			D = Integer.parseInt(input[1]);

			map = new boolean[N + 2];
			map[0] = true;
			map[N + 1] = true;
			input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				if (input[i].equals("1"))
					map[i + 1] = true;
			}

			cnt = 0;
			for (int i = 0; i < map.length; i++) {
				for (int k = 0; k < D; k++) {
					if (map[i + k] == true) {
						break;
					} else if (k == D - 1) {
						map[i + k] = true;
						cnt++;
						break;
					}
				}
			}
			bw.write("#"+Integer.toString(testcase)+" ");
			bw.write(Integer.toString(cnt)+"\n");
		}
		bw.flush();
		bw.close();
	}
}