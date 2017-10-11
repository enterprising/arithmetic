package arithmetic4.sort;

/**
 * 堆排序
 */
public class Heap {

    public static void main(String[] args) {
        int[] a = new int[]{5, 2, 4, 6, 7};
        heap(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void heap(int[] a) {
        int n = a.length;
        // 调整序列的前半部分元素，调整完之后第一个元素是序列的最大的元素
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjust(a, i, n);
        }

        for (int i = n - 1; i > 0; i--) {
            // 将第1个元素与当前最后一个元素交换，保证当前的最后一个位置的元素都是现在的这个序列中最大的
            SortUtil.exch(a, 0, i);
            // 不断缩小调整heap的范围，每一次调整完毕保证第一个元素是当前序列的最大值
            adjust(a, 0, i);
        }
    }

    private static void adjust(int[] a, int i, int n) {
        int child;
        for (; 2 * i + 1 < n; i = child) {
            child = 2 * i + 1; //子节点的位置 = 2*i+1
            // 如果较大的子结点大于父结点那么把较大的子结点往上移动，替换它的父结点
            if (child < n - 1 && a[child + 1] > a[child])
                child++;
            // 如果较大的子结点大于父结点那么把较大的子结点往上移动，替换它的父结点
            if (a[i] < a[child]) {
                SortUtil.exch(a, i, child);
            } else
                break;
        }
    }

}
