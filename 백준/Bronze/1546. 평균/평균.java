import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int MAX=0;
		double sum=0;
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(input[i]);
			if(nums[i]>MAX)
				MAX = nums[i];
		}
		for(int i=0; i<N; i++) {
			sum+=((double)nums[i]/MAX)*100;
		}
		System.out.println(sum/N);
	}
}
