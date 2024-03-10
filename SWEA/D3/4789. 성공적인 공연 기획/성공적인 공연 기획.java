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
		int[] info;
		int cnt_need, cnt_audience, L;

		for (int testcase = 1; testcase <= T; testcase++) {
			input = br.readLine().split("");
			L = input.length;
			info = new int[L];
			for (int i = 0; i < L; i++)
				info[i] = Integer.parseInt(input[i]);
			cnt_need = 0;
			cnt_audience = 0;

			for (int i = 0; i < L; i++) {
				if (cnt_audience >= i)
					cnt_audience += info[i];
				else {
					cnt_need += i - cnt_audience;
					cnt_audience = i;
					cnt_audience += info[i];
				}
			}
			bw.write("#"+Integer.toString(testcase)+" "+Integer.toString(cnt_need)+"\n");
		}
		bw.flush();
		bw.close();
	}
}