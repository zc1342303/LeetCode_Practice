package practice;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int n1 = nums1.length;
        int n2 = nums2.length;

        int total = (n1 + n2) / 2;
        int left = 0, right = n1;

        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = total - i;

            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }

        int i = left;
        int j = total - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == n1 ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n2 ? Integer.MAX_VALUE : nums2[j];

        if ((n1 + n2) % 2 == 0) {
            return ((double) Math.min(nums1RightMin, nums2RightMin) + Math.max(nums1LeftMax, nums2LeftMax)) / 2;
        }
        return (double) Math.min(nums1RightMin, nums2RightMin);
    }

}

