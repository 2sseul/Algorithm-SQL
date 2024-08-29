import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int now;
		Node left;
		Node right;
		Node(int now, Node left, Node right){
			this.now = now;
			this.left = left;
			this.right = right;
		}
	}
	static int answer[];
	static int idx;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		List<Integer> list = new ArrayList<>();
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			list.add(n);
		}
		sc.close();
		
		Node root = new Node(list.get(0), null, null);
		for(int i=1; i<list.size(); i++) {
			InsertNode(list.get(i), root);
		}
		
		answer = new int[list.size()];
		idx = 0;
		PostOrder(root);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(answer[i]);
		}
	}
	static void PostOrder(Node root) {
		if(root!=null) {
			PostOrder(root.left);
			PostOrder(root.right);
			answer[idx++] = root.now;
		}
	}
	static void InsertNode(int child, Node root) {
		if(child < root.now) {
			if(root.left != null) {
				InsertNode(child, root.left);
			}else {
				root.left = new Node(child, null, null);
			}
		}else {
			if(root.right != null) {
				InsertNode(child, root.right);
			}else {
				root.right = new Node(child, null, null);
			}
		}
	}
}
