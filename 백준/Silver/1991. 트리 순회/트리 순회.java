import java.io.*;
import java.util.*;

public class Main{
	static class Node{
		char N;
		Node left;
		Node right;
		Node(char N){
			this.N = N;
			this.left = left;
			this.right = right;
		}
	}
	static Node[] tree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		tree = new Node[n+1];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char nodeValue = st.nextToken().charAt(0);
			char leftValue = st.nextToken().charAt(0);
			char rightValue = st.nextToken().charAt(0);
			
			if(tree[nodeValue - 'A'] == null) {
				tree[nodeValue - 'A'] = new Node(nodeValue);
			}
			if(leftValue != '.') {
				tree[leftValue - 'A'] = new Node(leftValue);
				tree[nodeValue - 'A'].left = tree[leftValue - 'A'];
			}
			if(rightValue != '.') {
				tree[rightValue - 'A'] = new Node(rightValue);
				tree[nodeValue - 'A'].right = tree[rightValue - 'A'];
			}
		}
		
		preOrder(tree[0]);
		System.out.println();
		inOrder(tree[0]);
		System.out.println();
		postOrder(tree[0]);
	}
	
	static void preOrder(Node node) {
		if(node == null) return;
		System.out.print(node.N);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	static void inOrder(Node node) {
		if(node == null) return;
		inOrder(node.left);
		System.out.print(node.N);
		inOrder(node.right);
	}
	
	static void postOrder(Node node) {
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.N);
	}
	
}
