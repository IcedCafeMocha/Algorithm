import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] dwarf = new int[9];
		for (int i = 0; i < 9; i++)
			dwarf[i] = Integer.parseInt(br.readLine());

		int sum, idx, k, j = 0;
		a: for (k = 0; k < 8; k++) {
			for (j = k + 1; j < 9; j++) {
				sum = 0;
				for (idx = 0; idx < 9; idx++) {
					if (idx != k && idx != j) {
						sum += dwarf[idx];
					}
				}
				if (sum == 100) {
					break a;
				}
			}
		}
		int[] result = new int[7];
		idx = 0;
		for (int i = 0; i < 9; i++) {
			if (i != k && i != j) {
				result[idx++] = dwarf[i];
			}
		}
		Arrays.sort(result);
		for (int i = 0; i < 7; i++) {
			bw.write(String.valueOf(result[i]));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
