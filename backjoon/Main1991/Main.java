package backjoon.Main1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Node{
    char cur;
    Node left;
    Node right;
    Node(char cur){
        this.cur = cur;
    }
}
class Tree{
    Node root;
    void createNode(char data, char leftData,char rightData){
        //시작 (A)
        if(root==null){
            root = new Node(data);
            if(leftData!='.'){
                root.left = new Node(leftData);
            }
            if(rightData!='.'){
                root.right = new Node(rightData);
            }
        }
        else{
            searchNode(root,data,leftData,rightData);
        }
    }
    void searchNode(Node cur,char data,char leftData,char rightData){
        if(cur==null)return;
        if(cur.cur==data){

            if(leftData!='.'){
                cur.left = new Node(leftData);
            }
            if(rightData!='.'){
                cur.right = new Node(rightData);
            }
            return;
        }
        else{
            searchNode(cur.left,data,leftData,rightData);
            searchNode(cur.right,data,leftData,rightData);
        }
    }
    void preorder(Node node){
        if(node==null)return;
        System.out.print(node.cur);
        preorder(node.left);
        preorder(node.right);
    }
    void inorder(Node node){
        if(node==null)return;
        inorder(node.left);
        System.out.print(node.cur);
        inorder(node.right);
    }
    void postorder(Node node){
        if(node==null)return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.cur);
    }
}
public class Main {
    static int N;
    static Node Root;
    public static void main(String arg[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

       Tree tree = new Tree();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            tree.createNode(root,a,b);
        }
        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
        System.out.println();
    }
}
