import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	static boolean[] ch = new boolean[9];
	// 결과값 저장할 배열
	static int[] result = new int[9];
	// 규영이와 인영이의 카드 정보를 저장할 배열
	static int[] cards_k = new int[9];
	static int[] cards_i = new int[9];
	static int win, lose;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;

		// 테스트 케이스 개수만큼 수행
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			input = br.readLine().split(" ");

			// 규영이의 카드 정보 받기
			for (int i = 0; i < 9; i++) {
				cards_k[i] = Integer.parseInt(input[i]);
			}

			// 인영이가 가진 카드 찾아서 배열에 저장
			int t = 0;
			get: for (int i = 1; i <= 18; i++) {
				for (int k = 0; k < 9; k++) {
					if (i == cards_k[k])
						continue get;
				}
				cards_i[t++] = i;
			}
			win = 0;
			lose = 0;
			game(0);

			bw.write("#");
			bw.write(Integer.toString(test_case));
			bw.write(" ");
			bw.write(Integer.toString(win));
			bw.write(" ");
			bw.write(Integer.toString(lose));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	// 카드게임
	public static void game(int idx) {
		// 기저조건
		if (idx == 9) {
			int score_k = 0;
			int score_i = 0;
			// 9라운드 게임 진행
			for (int i = 0; i < 9; i++) {
				if (cards_k[i] > result[i])
					score_k += cards_k[i] + result[i];
				else
					score_i += cards_k[i] + result[i];
			}
			if (score_k > score_i)
				win++;
			else
				lose++;
			return;
		}
		for (int i = 0; i < 9; i++) {
			// 이미 확인한 인덱스면 continue
			if (ch[i])
				continue;
			// 확인하지 않은 인덱스라면
			result[idx] = cards_i[i];
			ch[i] = true;
			game(idx + 1);
			ch[i] = false;
		}
	}
}
