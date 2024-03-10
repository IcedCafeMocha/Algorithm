import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cntS, cntD, cntH, cntC, num, pattern, idx;
		char[] input;
		boolean[] cards = new boolean[52];

		int T = Integer.parseInt(br.readLine());
		test: for (int testcase = 1; testcase <= T; testcase++) {
			input = br.readLine().toCharArray();

			Arrays.fill(cards, false);
			cntS = 0;
			cntD = 0;
			cntH = 0;
			cntC = 0;
			pattern = 0;

			for (int i = 0; i < input.length; i += 3) {
				switch (input[i]) {
				case 'S':
					pattern = -1;
					break;
				case 'D':
					pattern = 12;
					break;
				case 'H':
					pattern = 25;
					break;
				case 'C':
					pattern = 38;
					break;
				}
				num = ((int) input[i + 1] - '0') * 10 + ((int) input[i + 2] - '0');
				idx = pattern + num;
				if (cards[idx] == true) {
					bw.write("#" + Integer.toString(testcase) + " ERROR\n");
					continue test;
				} else {
					cards[idx] = true;
					if (idx < 13)
						cntS++;
					else if (idx < 26)
						cntD++;
					else if (idx < 39)
						cntH++;
					else
						cntC++;
				}
			}
			bw.write("#" + Integer.toString(testcase) + " " + Integer.toString(13 - cntS) + " "
					+ Integer.toString(13 - cntD) + " " + Integer.toString(13 - cntH) + " "
					+ Integer.toString(13 - cntC));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}