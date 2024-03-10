import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[100][100];
		int x1, y1, x2, y2;
		for (int i = 0; i < 4; i++) {
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			for(int r=y1; r<y2; r++) {
				for(int c=x1; c<x2; c++) {
					if(map[r][c]==0)
						map[r][c]=1;
				}
			}
		}
		int sum=0;
		for(int r=0; r<100; r++)
			for(int c=0; c<100; c++)
				if(map[r][c]==1)
					sum++;
		System.out.println(sum);
	}
}
