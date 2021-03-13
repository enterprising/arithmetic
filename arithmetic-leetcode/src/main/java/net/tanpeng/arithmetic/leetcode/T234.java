package net.tanpeng.arithmetic.leetcode;

import net.tanpeng.arithmetic.offers.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: peng.tan
 * @create: 2021/03/08 16:49
 */
public class T234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        // 双指针
        int left = 0;
        int right = list.size()-1;
        while (left<right){
            if (!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
