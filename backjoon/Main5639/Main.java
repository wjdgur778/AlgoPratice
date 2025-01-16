package backjoon.Main5639;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {
    public Node node;

    BinarySearchTree(int data) {
        this.node = new Node(data, null, null);
    }

    public void postorder(Node cur) {
        if (cur.left != null)
            postorder(cur.left);
        if (cur.right != null) {
            postorder(cur.right);
        }
        System.out.println(cur.data);
    }

    public void addNode(int data) {
        Node tmp = node;
        while (true) {
            if (data < tmp.data) {
                if (tmp.left == null) {
                    tmp.left = new Node(data, null, null);
                    return;
                }
                tmp = tmp.left;
            } else {
                if (tmp.right == null) {
                    tmp.right = new Node(data, null, null);
                    return;
                }
                tmp = tmp.right;
            }
        }
    }

}

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinarySearchTree btree = null;
        Node cur = null;
        int idx = 0;

        while (true) {
            try {
                String str = br.readLine();
                if("".equals(str))break;
                int num = Integer.parseInt(str);
                if (idx == 0) {
                    btree = new BinarySearchTree(num);
                } else {
                    btree.addNode(num);
                }
                idx++;
            } catch (NumberFormatException e) {
                break;
            }
        }

        btree.postorder(btree.node);
    }
}
