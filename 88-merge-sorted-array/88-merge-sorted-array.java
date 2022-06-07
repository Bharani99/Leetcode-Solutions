class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(m < nums1.length)nums1[m++] = nums2[--n];
        Arrays.sort(nums1);
    }
}