package practice.binarytree;

class Tree {

    class Element {
        Element left;
        Element right;
        char c;

        Element(char c) {
            this.c = c;
        }
        char getchar(){
            return this.c;
        }
    }

    Element root=null;

    /**
     * 0
     * 1 2
     * 3 4 5 6
     * 7 8 9 10 11 12 13 14
     * root -> root.left -> root.right
     */
    Element maketree(char[] a, Element root, int i) {
        if (i < a.length) {
            root = new Element(a[i]);
            root.left = maketree(a, root.left, 2 * i + 1);
            root.right = maketree(a, root.right, 2 * i + 2);
        }
        return root;
    }

    Element inorder(Element root){
        if(root!=null) {
            root.left = inorder(root.left);
            System.out.print(root.c+" ");
            root.right = inorder(root.right);
        }
        return root;
    }
    Element preorder(Element root){
        if(root!=null) {
            System.out.print(root.c+" ");
            root.left = preorder(root.left);
            root.right = preorder(root.right);
        }
        return root;
    }

}

public class Binarytree {
    static char[] arr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    static Tree tree = new Tree();

    public static void main(String[] args) {

        tree.root = tree.maketree(arr, tree.root, 0);
        /*
        <중위순회>
        왼쪽 print 오른쪽
         */
        tree.inorder(tree.root);
        System.out.println();
        tree.preorder(tree.root);

    }

}
