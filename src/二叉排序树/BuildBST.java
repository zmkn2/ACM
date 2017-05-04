package 二叉排序树;

/**
 * Created by zmkn2 on 2017/4/19.
 */
public class BuildBST {
    static class BSTNode {
        int key;
        BSTNode left, right;
        BSTNode(int element){
            key = element;
        }
    }
    public static void main(String[] args) {

        int a[] = {4,5,2,1,0,9,3,7,6,8};
        int n = 10;
        BSTNode T = new BSTNode(4);
        T = createBST(T, a, 1);
        if( T ==null) System.out.println("asdfargrt");
        inOrderTraverse(T);
        return ;
    }
    public static BSTNode BSTInsert(BSTNode root, int element ){
        if(root ==null){
            root = new BSTNode(element);
            //.out.println(element);
            return root;
        }
        if( root.key == element) return root;
        else if( root.key > element) {
            root.left = BSTInsert(root.left, element);
            return root;
        }
        root .right = BSTInsert(root.right, element);
        return root;
    }

    public static BSTNode createBST(BSTNode root, int a[], int n){
        for( int i = 0; i < a.length; i++){
            BSTInsert(root, a[i]);
        }
        return root;
    }
    static void inOrderTraverse( BSTNode root){
        if( root != null){
            inOrderTraverse(root.left);
            System.out.print(root.key);
            inOrderTraverse(root.right);
        }
    }
}
