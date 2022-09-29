class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        HashMap<Integer, HashSet<Integer>> dependant = new HashMap<>();
        
        HashSet<Integer> set;
        for(int[] prereq : prerequisites){
            in[prereq[0]]++;
            
            set = dependant.getOrDefault(prereq[1], new HashSet<>());
            set.add(prereq[0]);
            dependant.put(prereq[1], set);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(in[i] == 0) q.add(i);
        }

        int curr;
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            curr = q.poll();
            ans.add(curr);
            for(int dep : dependant.getOrDefault(curr, new HashSet<>())){
                in[dep]--;
                if(in[dep] == 0) q.add(dep);
            }
        }
        return (ans.size() != numCourses) ? new int[0] : ans.stream().mapToInt(i -> i).toArray();
    }
}