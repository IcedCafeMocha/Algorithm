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

		int T = Integer.parseInt(br.readLine());

		String[] input;
		int[] nums;
		int MAX, MIN, sum, cnt;

		for (int testcase = 1; testcase <= T; testcase++) {
			sum = 0;
			MAX = 0;
			cnt = 0;
			MIN = 10000;
			input = br.readLine().split(" ");
			nums = new int[10];
			for (int i = 0; i < 10; i++) {
				nums[i] = Integer.parseInt(input[i]);
				if (nums[i] > MAX)
					MAX = nums[i];
				if (nums[i] < MIN)
					MIN = nums[i];
			}
			Arrays.sort(nums);
			for (int i = 1; i < 9; i++) {
				if (nums[i] != MAX && nums[i] != MIN) {
					sum += nums[i];
					cnt++;
				}
			}
			bw.write("#" + Integer.toString(testcase) + " " + Integer.toString(Math.round((float) sum / cnt)) + "\n");
		}
		bw.flush();
		bw.close();
	}
}