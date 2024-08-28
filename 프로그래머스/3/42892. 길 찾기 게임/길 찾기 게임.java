import java.io.*;
import java.util.*;

class Solution {
    static int index = 0;
    static int[][] answer;
    //1. Node를 생성해준다.
    static class Node{
        int idx;
        int x;
        int y;
        Node left;
        Node right;
        Node(int idx, int x, int y, Node left, Node right){
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        //2. Node형식에 맞춰 대입해준다. left, right는 null(아직 노드가 없는 상태)
        Node node[] = new Node[nodeinfo.length];
        for(int i=0; i<nodeinfo.length; i++){
            node[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1], null, null);
        }
        
        //3. node배열을 정렬해준다. y값을 기준으로! 같을 경우 x가 작은 순서로 정렬
        //0번째 node[0]이 root가 되기 때문.
        Arrays.sort(node, new Comparator<>(){
           public int compare(Node n1, Node n2){
               if(n1.y == n2.y){
                   return n1.x - n1.x;
               }
               return n2.y - n1.y;
           } 
        });
        
        //4. 이제 루트값을 넣어 줄것임!
        Node root = node[0];
        
        for(int i=1; i<nodeinfo.length; i++){
            //각 노드를 root로 하는 node를 추가해줘야 한다.
            InsertNode(root, node[i]);
        }
        
        answer = new int[2][nodeinfo.length];
        index = 0;
        Preorder(root);
        index = 0;
        Postorder(root);
        
        return answer;
    }
    //6. 후위순회 L > R > 루트
    public void Postorder(Node root){
        if(root != null){
            Postorder(root.left);
            Postorder(root.right);
            answer[1][index++] = root.idx;
        }
    }
    //5. 전위순회 루트 > L > R
    public void Preorder(Node root){
        //root에 트리가 존재할 경우
        if(root != null){
            answer[0][index++] = root.idx;
            Preorder(root.left);
            Preorder(root.right);
        }
    }
    public void InsertNode(Node root, Node child){
        //만약에 root의 x가 자식노드의 x보다 작으면, 이제 왼쪽에 넣어야 한다는 것.
        if(root.x > child.x){
            //엥 근데 left에 노드가 이미 있어
            if(root.left != null){
                //그럼 하나 더 내려가
                InsertNode(root.left, child);
            //근데 left에 없어
            }else{
                //그러면 이제 left에 넣어야겠지.
                root.left = child;
            }
        }else{
            //엥 근데 right에 노드가 이미 있어
            if(root.right != null){
                //그럼 하나 더 내려가
                InsertNode(root.right, child);
            //근데 right에 자리가 있네?
            }else{
                //그럼 거기가 내자리
                root.right = child;
            }
        }
        
    }
}