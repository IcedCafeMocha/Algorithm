import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		String[] input;
		int MIN=Integer.MAX_VALUE, sum1, sum2;
		boolean now;
		
		input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		boolean map[][] = new boolean[N][M];
		
		for(int r=0; r<N; r++) {
			input = br.readLine().split("");
			for(int c=0; c<M; c++) {
				if(input[c].equals("B"))
					map[r][c] = true;
			}
		}
		
		for(int r=0; r<=N-8; r++) {
			for(int c=0; c<=M-8; c++) {
				sum1 = 0;
				sum2 = 0;
				now = map[r][c];
				for(int i=0; i<8; i+=2) {
					for(int k=0; k<8; k+=2) {
						if(map[r+i][c+k]!=now)
							sum1++;
						else
							sum2++;
						if(map[r+i][c+k+1]==now)
							sum1++;
						else
							sum2++;
					}
					for(int k=0; k<8; k+=2) {
						if(map[r+i+1][c+k]==now)
							sum1++;
						else
							sum2++;
						if(map[r+i+1][c+k+1]!=now)
							sum1++;
						else
							sum2++;
					}
				}
				if(sum1<MIN)
					MIN = sum1;
				if(sum2<MIN)
					MIN = sum2;
			}
				
		}
		System.out.println(MIN);
		
	}
}