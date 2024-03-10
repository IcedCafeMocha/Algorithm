import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 라운드 수 N
		int N = Integer.parseInt(br.readLine());
		
		// N만큼 게임 수행
		String[] input;
		int[] p1, p2;
		for(int i=0; i<N; i++) {
			// 각 플레이어가 가진 딱지 종류별 개수를 세기 위한 배열
			// 1 = ▲, 2 = ■, 3 = ●, 4 = ★
			p1 = new int[5];
			p2 = new int[5];
			
			// 각 라운드의 플레이어 정보 입력받기
			// player1
			input = br.readLine().split(" ");
			for(int k=1; k<=Integer.parseInt(input[0]); k++)
				p1[Integer.parseInt(input[k])]++;
			
			// player2
			input = br.readLine().split(" ");
			for(int k=1; k<=Integer.parseInt(input[0]); k++)
				p2[Integer.parseInt(input[k])]++;
				
			// 승패 반별
			if(p1[4]!=p2[4]) {
				if(p1[4]>p2[4])
					System.out.println("A");
				else
					System.out.println("B");
			}else {
				if(p1[3]!=p2[3]) {
					if(p1[3]>p2[3])
						System.out.println("A");
					else
						System.out.println("B");
				}else {
					if(p1[2]!=p2[2]) {
						if(p1[2]>p2[2])
							System.out.println("A");
						else
							System.out.println("B");
					}else {
						if(p1[1]!=p2[1]) {
							if(p1[1]>p2[1])
								System.out.println("A");
							else
								System.out.println("B");
						}else {
							System.out.println("D");
						}
					}
				}
			}
			
		}
		
	}
}
