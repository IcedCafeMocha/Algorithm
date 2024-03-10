import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution{
	public static void main(String args[]) throws Exception{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(rd.readLine()); // 테스트 케이스 개수 T 입력받기
		List<Integer> N_List = new ArrayList<>(); // N을 저장할 리스트 생성
		int[][] result = new int[T][50]; // 답을 저장할 배열 생성
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(rd.readLine()); // 주어지는 숫자의 개수 N 입력받기
			N_List.add(N);
			String input = rd.readLine(); // 숫자 입력받기
			String[] str = input.split(" ");
			int[] ary = new int[N];
			for (int k = 0; k < str.length; k++) {
				ary[k] = Integer.parseInt(str[k]); // 주어진 N개의 숫자를 ary 배열에 저장
			}

			// 버블 정렬
//			int tmp;
//			int cnt = 1;
//			while (cnt != 0) {
//				cnt = 0;
//				for (int k = 1; k < ary.length; k++) {
//					if (ary[k] < ary[k - 1]) {
//						tmp = ary[k - 1];
//						ary[k - 1] = ary[k];
//						ary[k] = tmp;
//						cnt++;
//					}
//				}
//			}
//			System.out.println(Arrays.toString(ary));

			// 선택 정렬
//			int MIN;
//			int tmp = 0;
//			for(int k=0; k<ary.length; k++) {
//				MIN = k;
//				for(int j=k; j<ary.length; j++) {
//					if(ary[MIN]>ary[j])
//						MIN = j;
//				}
//				tmp = ary[k];
//				ary[k]=ary[MIN];
//				ary[MIN]=tmp;
//			}
//			System.out.println(Arrays.toString(ary));

			// 카운팅 정렬
			int MAX = 0; // 최대값
			for (int k = 0; k < ary.length; k++) { // 최대값 찾기
				if (MAX < ary[k])
					MAX = ary[k];
			}
			int[] counter = new int[MAX + 1];
			for (int k = 0; k < ary.length; k++) {
				counter[ary[k]]++;
			}
			for (int k = 1; k < counter.length; k++) {
				counter[k] = counter[k] + counter[k - 1];
			}
			int[] temp = new int[N];
			for (int k = N - 1; k >= 0; k--) {
				counter[ary[k]]--;
				temp[counter[ary[k]]] = ary[k];
			}
			for (int k = 0; k < temp.length; k++) { // result 배열에 결과 저장
				result[i][k] = temp[k];
			}
		}
		// 결과 출력
		for (int i = 0; i < T; i++) {
			System.out.print("#" + (i + 1));
			for (int k = 0; k < N_List.get(i); k++) {
				System.out.print(" " + result[i][k]);
			}
			System.out.println();
		}
	}
}