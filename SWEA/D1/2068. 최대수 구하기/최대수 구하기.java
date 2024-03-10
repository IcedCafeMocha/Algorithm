import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
class Solution{
	public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		List<Integer> MAX = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			int[] tmp = new int[10];
			for (int k = 0; k < 10; k++) {
				tmp[k] = sc.nextInt();
			}
			Arrays.sort(tmp);
			MAX.add(tmp[9]);
		}
		for (int i = 0; i < T; i++) {
			System.out.printf("#%d %d\n", i + 1, MAX.get(i));
		}
	}
}