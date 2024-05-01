import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		String[] input;
		int N = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			if(sosu(Integer.parseInt(input[i])))
				cnt++;
		}
		System.out.println(cnt);
		
	}
	static public boolean sosu(int num) {
		if(num==1)
			return false;
		for(int i=2; i<=num/2; i++) {
			if(num%i==0)
				return false;
		}
		return true;
	}
}
