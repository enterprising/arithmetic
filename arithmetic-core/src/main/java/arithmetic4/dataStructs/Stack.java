package arithmetic4.dataStructs;

import java.util.Iterator;

/**
 * 栈的实现
 */
public class Stack<Integer> implements Iterable {

    private Node first; //栈顶
    private int N;

    private class Node {
        int item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;  //用 N==0 也是可以的
    }

    public int size() {
        return N;
    }

    // 向栈顶加元素
    public void push(int i) {
        Node oldFirst = first;
        first = new Node();
        first.item = i;
        first.next = oldFirst;
        N++;
    }

    // 从栈顶删除元素
    public int pop() {
        int item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator iterator() {
        return new ListIterators();
    }

    private class ListIterators implements Iterator {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            int i = current.item;
            current = current.next;
            return i;
        }
    }
}
