class Solution {
    int count;
    public int reversePairs(int[] nums) {
        count = 0;
        int[] aux = new int[nums.length];
        helper(nums, aux, 0, nums.length - 1);
        return count;
    }

    private void helper(int[] nums, int[] aux, int i, int j) {
        if (i >= j) return;
        int mid = (i + j) / 2;
        helper(nums, aux, i, mid);
        helper(nums, aux, mid + 1, j);
        merger(nums, aux, i, mid, j);
    }

    private void merger(int[] nums, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            aux[k] = nums[k];
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) nums[k] = aux[j++];
            else if (j > hi) nums[k] = aux[i++];
            else if (aux[i] > aux[j]) {
                //starting index where aux[i]>2*aux[j]
                int index = bSearch(aux, i, mid, 2 * (long) aux[j] + 1);
                if (index != -1) count += mid - index + 1;
                nums[k] = aux[j++];
            } else {
                if (aux[i] > 2 * (long) aux[j]) {
                    count++;
                    for (int x = j + 1; x <= hi; x++)
                        if (aux[i] > 2 * (long) aux[x]) count++;
                }
                nums[k] = aux[i++];
            }
        }
    }

    private int bSearch(int[] aux, int i, int j, long target) {
        while (i <= j) {
            int mid = (i + j) / 2;
            if (aux[mid] < target) i = mid + 1;
            else {
                if (mid == i || aux[mid - 1] < target) return mid;
                j = mid - 1;
            }
        }
        return -1;
    }
}