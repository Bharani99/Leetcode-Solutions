class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int time = 0;
        for(int[] course : courses){
            if(course[1] >= time + course[0]){
                time += course[0];
                pq.add(course[0]);
            }
            else if(!pq.isEmpty() && pq.peek() > course[0]){
                time += course[0] - pq.poll();
                pq.add(course[0]);
            }
        }
        return pq.size();
    }
}