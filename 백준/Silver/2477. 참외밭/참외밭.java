import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1 넓이에서 자라는 참외의 개수 K
		int K = Integer.parseInt(br.readLine());

		// 방향과 길이를 저장할 배열 생성
		int[] dir = new int[6];
		int[] len = new int[6];

		// 방향과 길이 정보 받기
		String[] input;
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < 6; i++) {
			input = br.readLine().split(" ");
			dir[i] = Integer.parseInt(input[0]);
			len[i] = Integer.parseInt(input[1]);
			// sum : 방향 값을 모두 더한 값
			sum += dir[i];
			// 값이 1인 dir 값 개수를 세서 cnt에 저장
			if (dir[i] == 1)
				cnt++;
		}

		// 형태 판별
		// 0 : ㄱ 모양, 90 : 90도 회전, 180 : 180도 회전, 270 : 270도 회전
		int shape = 0;
		switch (sum) {
		case 14:
			shape = 0;
			break;
		case 15:
			if (cnt == 1)
				shape = 270;
			else
				shape = 90;
			break;
		case 16:
			shape = 180;
			break;
		}

		// 판별한 형태에 따라 넓이 계산
		// dir에서 1:동. 2:서, 3:남, 4:북
		int result;
		List<Integer> list = new ArrayList<>();
		switch (shape) {
		case 0:
			for (int i = 0; i < 6; i++) {
				if (i == 5) {
					if (dir[i] == 4 && dir[0] == 2 || dir[i] == 1 && dir[0] == 3) {
						list.add(len[i] * len[0]);
					} else {
						continue;
					}
				} else if (dir[i] == 4 && dir[i + 1] == 2 || dir[i] == 1 && dir[i + 1] == 3) {
					list.add(len[i] * len[i + 1]);
				}
			}
			break;
		case 90:
			for (int i = 0; i < 6; i++) {
				if (i == 5) {
					if (dir[i] == 2 && dir[0] == 3 || dir[i] == 4 && dir[0] == 1) {
						list.add(len[i] * len[0]);
					} else {
						continue;
					}
				} else if (dir[i] == 2 && dir[i + 1] == 3 || dir[i] == 4 && dir[i + 1] == 1) {
					list.add(len[i] * len[i + 1]);
				}
			}
			break;
		case 180:
			for (int i = 0; i < 6; i++) {
				if (i == 5) {
					if (dir[i] == 3 && dir[0] == 1 || dir[i] == 2 && dir[0] == 4) {
						list.add(len[i] * len[0]);
					} else {
						continue;
					}
				} else if (dir[i] == 3 && dir[i + 1] == 1 || dir[i] == 2 && dir[i + 1] == 4) {
					list.add(len[i] * len[i + 1]);
				}
			}
			break;
		case 270:
			for (int i = 0; i < 6; i++) {
				if (i == 5) {
					if (dir[i] == 3 && dir[0] == 2 || dir[i] == 1 && dir[0] == 4) {
						list.add(len[i] * len[0]);
					} else {
						continue;
					}
				} else if (dir[i] == 3 && dir[i + 1] == 2 || dir[i] == 1 && dir[i + 1] == 4) {
					list.add(len[i] * len[i + 1]);
				}
			}
			break;
		}
		System.out.println(Math.abs(list.get(0) - list.get(1)) * K);
	}
}
