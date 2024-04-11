import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		int N = Integer.parseInt(br.readLine());
		int[] temp = new int[N];
		input = br.readLine().split(" ");
		for(int i=0; i<N; i++)
			temp[i] = Integer.parseInt(input[i]);
		Arrays.sort(temp);
		System.out.println(temp[0]+" "+temp[N-1]);
	}
}
