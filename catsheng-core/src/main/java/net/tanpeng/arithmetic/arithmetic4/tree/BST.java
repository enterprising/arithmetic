package net.tanpeng.arithmetic.arithmetic4.tree;

/**
 * 二叉查找树的实现
 */
public class BST {

    private Node root;   //二叉查找树的根

    private class Node {
        private int key;
        private int value;
        private Node left, right;
        private int N;      // 以该结点为根的子树中的结点总数

        Node(int key, int value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }

    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.N;
    }

    public int get(int key) {
        return get(root, key);
    }

    // 递归查找
    private int get(Node x, int key) {
        if (x == null)
            return -1;
        if (key > x.key)
            return get(x.right, key);
        else if (key < x.key)
            return get(x.left, key);
        else
            return x.value;
    }

    public void put(int key, int value) {
        //查找 key，找到则更新它的值，否则为它创建一个新的结点
        root = put(root, key, value);
    }

    private Node put(Node x, int key, int value) {
        //如果key存在于以x为根节点的子树中则更新它的值
        //否则将以key和value为键值对的新结点插入到该子树中
        if (x == null)
            return new Node(key, value, 1);
        if (key > x.key)
            x.right = put(x.right, key, value);
        else if (key < x.key)
            x.left = put(x.left, key, value);
        else
            x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

}
