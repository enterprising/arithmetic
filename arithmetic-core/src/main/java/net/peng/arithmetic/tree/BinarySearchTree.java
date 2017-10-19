package net.peng.arithmetic.tree;

/**
 * 二叉查找树
 */
public class BinarySearchTree {

    private TreeNode root;

    public int size() {
        return size(root);
    }

    private int size(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return node.n;
        }
    }

    /**
     * 非递归查找
     *
     * @param key
     * @return
     */
    public int get(int key) {
        TreeNode cur = root;
        while (cur != null) {
            if (key == cur.key) {
                return cur.value;
            } else if (key > cur.key) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return -1;
    }

    // 递归查找
    public int get2(int key) {
        int x = get(root, key);
        return x;
    }

    /**
     * 递归版的查找
     *
     * @param node
     * @param key
     * @return
     */
    private int get(TreeNode node, int key) {
        if (node == null) {
            return -1;
        }
        // 如果大于当前节点
        if (key > node.key) {
            return get(node.right, key);
        } else if (key < node.key) {
            return get(node.left, key);
        } else {
            return get(node.value);
        }
    }

    public void put(int key, int value) {
        root = put(root, key, value);
    }

    /**
     * 往二叉平衡树中插入数据
     * <p>
     * 注意递归算法中有返回值，插入时是从上往下的查找，然后在树的底部插入，
     * 然后在递归方法返回的过程中，是自下而上逐渐更新查找路径上的每个结点node的
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private TreeNode put(TreeNode node, int key, int value) {
        if (node == null) {
            return new TreeNode(key, value, 1);  //新节点的size。。当然是1
        }
        // 在node的左边插入
        if (key < node.key) {
            node.left = put(node.left, key, value);
        }
        // 在node的右边插入
        else if (key > node.key) {
            node.right = put(node.right, key, value);
        }
        // 键已经存在。。更新value
        else {
            node.value = value;
        }
        // 插入之后更新以node节点为根的字数节点总数目。 递归会先向下，再往上回
        node.n = size(node.left) + size(node.right) + 1;
        // 除了第一次put返回新节点外，都是返回root
        return node;
    }

}
