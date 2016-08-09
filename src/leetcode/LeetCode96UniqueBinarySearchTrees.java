/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode96UniqueBinarySearchTrees {

    public int numTrees(int n) {

        List<Integer> list = new ArrayList<Integer>(Collections.nCopies(n + 1, 0));

        list.set(0, 1);
        list.set(1, 1);

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                list.set(i, list.get(i) + list.get(j - 1) * list.get(i - j));
            }
        }

        return list.get(n);

    }

}
