import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
	int data, num;
	Node left;
	Node right;
	Node parent;

	Node() {
	}

	Node(int data) {
		this.data = data;
	}
}

public class Solution {
	static List<Integer> list = new ArrayList<>();
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 수 N 입력받기
		int N = Integer.parseInt(br.readLine());
		int V, E, n1, n2;

		// N만큼 테스트 반복 수행
		for (int i = 0; i < N; i++) {
			// V, E, n1, n2 입력 받기
			String[] input = null;
			input = br.readLine().split(" ");
			// V : 정점의 개수
			// E : 간선의 개수
			// n1, n2 : 공통 조상을 찾는 두 개의 정점 번호
			V = Integer.parseInt(input[0]);
			E = Integer.parseInt(input[1]);
			n1 = Integer.parseInt(input[2]);
			n2 = Integer.parseInt(input[3]);

			// E개 간선 입력받기 (부모-자식 순서) => 총 입력은 E*2개
			String[] input2 = br.readLine().split(" ");
			int[] edge = Arrays.stream(input2).mapToInt(Integer::parseInt).toArray();
			
			// 간선 개수 +1 = 정점 개수이므로, E+2 만큼의 노드 배열 생성
			Node[] nodes = new Node[E + 2];

			for (int k = 0; k < E + 2; k++) {
				nodes[k] = new Node();
				nodes[k].num = k;
			}

			for (int k = 0; k < E * 2 - 1; k += 2) {
				int parent = edge[k];
				int child = edge[k + 1];

				nodes[child].parent = nodes[parent];

				// 왼쪽부터 자녀 노드를 채워 넣는다.
				if (nodes[parent].left == null) {
					nodes[parent].left = nodes[child];
				} else {
					nodes[parent].right = nodes[child];
				}
			}

			// 가장 가까운 공통 조상 찾기
			int MAX = 1;

			find(nodes[n1]);
			int[] result1 = new int[list.size()];
			for (int k = 0; k < list.size(); k++)
				result1[k] = list.get(k);
			
			list.clear();
			
			find(nodes[n2]);
			int[] result2 = new int[list.size()];
			for (int k = 0; k < list.size(); k++)
				result2[k] = list.get(k);
			
			for (int k = result1.length-1, j=result2.length-1; k >= Math.abs(result1.length-result2.length); k--, j--) {
				if (result1[k] == result2[j]) {
					MAX = result1[k];
				}
			}
			
			System.out.print("#"+ (i+1)+" ");
			
			System.out.print(MAX);
			list.clear();

			counter(nodes[MAX]);
			System.out.println(" "+ cnt / 2);
			cnt = 0;
		}
	}

	// 조상 찾아서 리스트에 저장
	static void find(Node node) {
		if (node.num == 1) {
			list.add(1);
			return;
		}
		list.add(node.num);
		find(node.parent);
	}

	// 루트로 하는 서브 트리 개수 찾기
	static void counter(Node node) {
		if (node == null) {
			cnt++;
			return;
		}
		cnt++;
		counter(node.left);
		counter(node.right);

	}
}