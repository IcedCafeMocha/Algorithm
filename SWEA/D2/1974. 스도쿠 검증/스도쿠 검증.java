import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] count;

		// 퍼즐 데이터를 입력받을 배열 생성
		int[][] ary = new int[9][9];

		// 테스트 케이스 개수 T 입력받기
		int T = sc.nextInt();

		// T 만큼 테스트 수행
		test: for (int i = 0; i < T; i++) {
			System.out.print("#" + (i + 1) + " ");

			// ary 배열에 퍼즐 데이터 입력받기
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					ary[r][c] = sc.nextInt();
				}
			}

			// 가로
			for (int r = 0; r < 9; r++) {
				// 중복 확인할 배열 생성 및 초기화
				count = new int[10];
				for (int c = 0; c < 9; c++) {
					count[ary[r][c]]++;
					if (count[ary[r][c]] > 1) {
						System.out.print(0 + "\n");
						continue test;
					}
				}
			}

			// 세로
			for (int c = 0; c < 9; c++) {
				// 중복 확인할 배열 생성 및 초기화
				count = new int[10];
				for (int r = 0; r < 9; r++) {
					count[ary[r][c]]++;
					if (count[ary[r][c]] > 1) {
						System.out.print(0 + "\n");
						continue test;
					}
				}
			}

			// 격자
			for (int r = 0; r < 9; r += 3) {
				// 중복 확인할 배열 생성 및 초기화
				for (int c = 0; c < 9; c += 3) {
					count = new int[10];
					for (int k = 0; k < 3; k++) {
						for (int j = 0; j < 3; j++) {
							count[ary[r + k][c + j]]++;
							if (count[ary[r + k][c + j]] > 1) {
								System.out.print(0 + "\n");
								continue test;
							}
						}
					}
				}
			}
			// 모든 연산 후에도 0이 나오지 않았다면
			System.out.print(1);
			System.out.println();
		}
	}
}
