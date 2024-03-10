import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 남학생 : 받은 스위치 번호가 자기가 받은 수의 배수 -> 스위치 상태 바꾼다.
		// 여학생 : 받은 스위치 번호와 같은 번호의 스위치를 중심으로,
		// 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾고, 모두 바꾼다. 항상 홀수.

		// 스위치의 개수 N
		int N = Integer.parseInt(br.readLine());
		// 각 스위치의 상태 정보 입력받기 (ON : 1, OFF : 2)
		String[] input;
		input = br.readLine().split(" ");
		int[] sw = new int[N];
		for (int i = 0; i < N; i++)
			sw[i] = Integer.parseInt(input[i]);
		
		// 학생 수 st_num
		int stu_num = Integer.parseInt(br.readLine());
		// 학생 정보 입력받기 (남학생 : 1, 여학생 : 2 / 학생이 받은 스위치 수)
		int num, j;
		for (int i = 0; i < stu_num; i++) {
			input = br.readLine().split(" ");
			// 입력받은 스위치 수 num
			num = Integer.parseInt(input[1])-1;
			// 남학생의 경우
			if (input[0].equals("1")) {
				// num의 배수인 스위치의 상태를 바꾼다
				for (int k = 1; ((num+1) * k) - 1< N; k++) {
					if (sw[((num+1) * k) - 1] == 0)
						sw[((num+1) * k) - 1] = 1;
					else
						sw[((num+1) * k) - 1] = 0;
				}
			} else {
				// 여학생의 경우
				j = 1;
				if (sw[num] == 0)
					sw[num] = 1;
				else
					sw[num] = 0;
				while (num + j < N && num - j >= 0) {
					if (sw[num + j] == sw[num - j]) {
						if (sw[num + j] == 0) {
							sw[num + j] = 1;
							sw[num - j] = 1;
						} else {
							sw[num + j] = 0;
							sw[num - j] = 0;
						}
					} else {
						break;
					}
					j++;
				}
			}
		}
		// 20개씩 나눠서 출력
		result : for(int i=0; i<N; i+=20) {
			for(int k=0; k<20; k++) {
				bw.write(String.valueOf(sw[i+k]));
				bw.write(" ");
				if(i+k==N-1)
					break result;
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
