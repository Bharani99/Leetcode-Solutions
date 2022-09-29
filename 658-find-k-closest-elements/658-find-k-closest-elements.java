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
        Deque<Integer> dq = new ArrayDeque<>();
        int left = pos - 1, right = pos;
        while(k > 0){
            if(right >= arr.length)
                dq.addFirst(arr[left--]);
            else if(left < 0) dq.addLast(arr[right++]);
            else if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x))
                dq.addFirst(arr[left--]);
            else dq.addLast(arr[right++]);
            k--;
        }
        List<Integer> ans = new ArrayList<>();
        while(!dq.isEmpty())ans.add(dq.poll());
        return ans;
    }
}