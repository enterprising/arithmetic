package offers;

/**
 * 剑指Offer 第66题：寻找矩阵中的路径。
 * <p>
 * 题目描述：
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子
 * <p>
 * 思路及考点：回溯 递归
 * <p>
 * Created by peng.tan on 17/9/24.
 */
public class T66 {

    public static void main(String[] args) {

        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4, "ABCCED".toCharArray()));

    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null)
            return false;
        boolean[] visited = new boolean[matrix.length];  //用于记录这个是否已经被访问过
        int[] visited2 = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, i, j, str, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, int i, int j, char[] str, int pathLength, boolean[] visited) {
        // 这里的 i*cols + j，代表当前访问的这个格子。（因为给的数据是一维数组，这个挺坑的）
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[pathLength] || visited[index])
            return false;
        //代表比对结束，存在这样一条数据
        if (pathLength == str.length - 1)
            return true;
        visited[index] = true;
        // 递归遍历当前格子的前后左右四个格子
        if (hasPathCore(matrix, rows, cols, i - 1, j, str, pathLength + 1, visited)
                || hasPathCore(matrix, rows, cols, i + 1, j, str, pathLength + 1, visited)
                || hasPathCore(matrix, rows, cols, i, j - 1, str, pathLength + 1, visited)
                || hasPathCore(matrix, rows, cols, i, j + 1, str, pathLength + 1, visited)) {
            return true;
        }
        visited[index] = false;
        return false;
    }


    private static boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
            return false;
        if (k == str.length - 1) return true;
        flag[index] = 1;
        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
            return true;
        }
        flag[index] = 0;
        return false;
    }

}
