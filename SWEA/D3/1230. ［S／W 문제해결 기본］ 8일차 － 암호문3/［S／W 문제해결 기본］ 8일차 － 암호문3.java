import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
	String data;
	Node link;

	Node() {}
	
	Node(String data){
		this.data = data;
	}
}

class SinglyLinkedList{
	Node head;
	int size;
	
	SinglyLinkedList(){
		head = new Node();
	}
	
	// 삽입
	// 제일 앞에 삽입
	void addFirst(String data) {
		Node newNode = new Node(data);
		newNode.link = head.link;
		head.link = newNode;
		
		size++;
	}
	
	// 맨 뒤에 삽입
	void addLast(String data) {
		Node newNode = new Node(data);
		
		Node curr = head;
		while(curr.link != null)
			curr = curr.link;
		
		curr.link = newNode;
		
		size++;
	}
	
	// 중간 삽입
	void add(int index, String data) {
		if(index < 0 || index > size)
			return;
		else {
			Node curr = head;
			for(int i=0; i<index; i++)
				curr = curr.link;
			Node newNode = new Node(data);
			newNode.link = curr.link;
			curr.link = newNode;
			
			size++;
		}
	}
	
	// 삭제
	// 지정한 인덱스에 해당되는 노드 삭제
	void remove(int index) {
		if(index <0 || index >= size)
			return;
		else {
			Node curr = head;
			
			for(int i=0; i<index; i++)
				curr = curr.link;
			
			curr.link = curr.link.link;
			
			size--;
		}
	}
	
	// 앞 10개 조회 및 출력
	void printList() {
		Node curr = head.link;
		for(int i=0; i<10; i++) {
//		while(curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.link;
		}
		System.out.println();
	}
}

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 0;
		int M = 0;
		// 테스트케이스 10회 수행
		for (int i = 0; i < 10; i++) {
			
			N = Integer.parseInt(br.readLine());
			String[] ori = br.readLine().split(" ");
			M = Integer.parseInt(br.readLine());
			String[] order = br.readLine().split(" ");
			SinglyLinkedList result = new SinglyLinkedList();
			for(int k=0; k<N; k++) {
				result.addLast(ori[k]);
			}
			for(int k=0; k<order.length; k++) {
				if(order[k].equals("I")) {
					for(int j=Integer.parseInt(order[k+2])-1; j >=0 ; j--) {
						result.add(Integer.parseInt(order[k+1]), order[k+3+j]);
					}
				}
				else if(order[k].equals("D")) {
					for(int j=0; j<Integer.parseInt(order[k+2]); j++) {
						result.remove(Integer.parseInt(order[k+1]));
					}
				}else if(order[k].equals("A")){
					for(int j=0; j<Integer.parseInt(order[k+1]); j++) {
						result.addLast(order[k+2+j]);
					}
				}else
					continue;
				
			}
			System.out.printf("#%d ", i+1);
			result.printList();
		}
	}
}