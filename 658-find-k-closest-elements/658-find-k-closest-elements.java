class Solution {
    public int binarySearch(int[] arr, int target){
        int left = 0, right = arr.length, mid;
        while(left < right){
            mid = left + (right - left) / 2;
            if(arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pos = binarySearch(arr, x);
        List<Integer> dq = new LinkedList<>();
        int left = pos - 1, right = pos;
        while(k > 0){
            if(right >= arr.length)
                dq.add(0, arr[left--]);
            else if(left < 0) dq.add(arr[right++]);
            else if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x))
                dq.add(0, arr[left--]);
            else dq.add(arr[right++]);
            k--;
        }
        
        return dq;
    }
}