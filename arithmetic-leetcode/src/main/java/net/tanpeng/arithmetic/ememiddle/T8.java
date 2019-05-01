package net.tanpeng.arithmetic.ememiddle;

import java.util.Stack;

/**
 * 8. 翻转一个int，即输入12345，输出54321. 输入-123，输出-321
 * 点评: 候选人至少要考虑两个场景，负数和越界。其他的就是一些基本功的考察。写好也不容易。
 * <p>
 * Created by peng.tan on 2019/4/23.
 */
public class T8 {
    public static void main(String[] args) {
        int i = -2147483647;
        String x = i + "";
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean f = x.startsWith("-");
        for (char c : x.toCharArray()) {
            if (c == '-') {
                continue;
            }
            stack.push(c);
        }

        if (f) {
            System.out.print('-');
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.peek());
            sb.append(stack.pop());
        }

        // 越界的检查需要考虑进去
        Long result = Long.parseLong(sb.toString());
        System.out.println(Integer.MAX_VALUE);
        if (result>Integer.MAX_VALUE){
            System.out.println("越界了");
            // 这里还要梳理下，不过核心已经出来了，offer已经OK了
        }
    }
}
