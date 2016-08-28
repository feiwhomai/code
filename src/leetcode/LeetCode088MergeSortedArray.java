/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * 
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
package leetcode;

public class LeetCode088MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (0 == n) {
            return;
        }

        for (int i = 0; i < m; i++) {
            if (nums1[i] > nums2[0]) {
                int tmp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = tmp;

                for (int j = 0; j < n - 1; j++) {
                    if (nums2[j] > nums2[j + 1]) {
                        int tmp2 = nums2[j];
                        nums2[j] = nums2[j + 1];
                        nums2[j + 1] = tmp2;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        return;
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1, index = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index] = nums1[i];
                index--;
                i--;
            } else {
                nums1[index] = nums2[j];
                index--;
                j--;
            }
        }

        while (j >= 0) {
            nums1[index] = nums2[j];
            index--;
            j--;
        }

        while (i >= 0) {
            nums1[index] = nums1[i];
            index--;
            i--;
        }

        return;
    }
}
