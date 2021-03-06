/**
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * 
 * Note: You may assume that the string is well-formed:
 * 
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * Example 1:
 * 
 * Given s = "324",
 * 
 * You should return a NestedInteger object which contains a single integer 324.
 * Example 2:
 * 
 * Given s = "[123,[456,[789]]]",
 * 
 * Return a NestedInteger object containing a nested list with 2 elements:
 * 
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 *     i.  An integer containing value 456.
 *     ii. A nested list with one element:
 *          a. An integer containing value 789.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode385MiniParser {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public class NestedInteger {
        private Integer value;
        private List<NestedInteger> nestedIntegerList;

        // Constructor initializes an empty nested list.
        public NestedInteger() {
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.value = value;
        }

        // @return true if this NestedInteger holds a single integer, rather
        // than a nested list.
        public boolean isInteger() {
            return value != null && nestedIntegerList == null;
        }

        // @return the single integer that this NestedInteger holds, if it holds
        // a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return this.value;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            this.value = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested
        // integer to it.
        public void add(NestedInteger ni) {
            this.nestedIntegerList = new ArrayList<>();
            this.nestedIntegerList.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a
        // nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return this.nestedIntegerList;
        }
    }

    public NestedInteger deserialize(String s) {
        if (null == s || s.isEmpty()) {
            return new NestedInteger();
        }
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(r) == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
                l = r + 1;
            } else if (s.charAt(r) == ']') {
                String num = s.substring(l, r);
                if (!num.isEmpty()) {
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                if (!stack.isEmpty()) {
                    NestedInteger tmp = stack.pop();
                    tmp.add(curr);
                    curr = tmp;
                }
                l = r + 1;
            } else if (r > 0 && s.charAt(r) == ',') {
                if (s.charAt(r - 1) != ']') {
                    String num = s.substring(l, r);
                    if (!num.isEmpty()) {
                        curr.add(new NestedInteger(Integer.valueOf(num)));
                    }
                    l = r + 1;
                } else {
                    l++;
                }
            }
        }
        return curr;
    }
}
