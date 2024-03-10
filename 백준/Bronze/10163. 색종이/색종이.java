import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		
		// 색종이의 장수 N
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] map = new boolean[1001][1001];
		
		String[] input;
		int[] R = new int[N];
		int[] C = new int[N];
		int[] w = new int[N];
		int[] h = new int[N];
		int sum;
		
		for(int i=0; i<N; i++) {
			input = br.readLine().split(" ");
			C[i] = Integer.parseInt(input[0]);
			R[i] = Integer.parseInt(input[1]);
			w[i] = Integer.parseInt(input[2]);
			h[i] = Integer.parseInt(input[3]);
		}
		
		for(int i=N-1; i>=0; i--) {
			sum = 0;
			for(int r=0; r<h[i]; r++) {
				for(int c=0; c<w[i]; c++) {
					if(map[R[i]+r][C[i]+c]==false) {
						map[R[i]+r][C[i]+c]=true;
						sum++;
					}
				}
			}
			list.add(sum);
		}
		for(int i=N-1; i>=0; i--)
			System.out.println(list.get(i));
	}
}
