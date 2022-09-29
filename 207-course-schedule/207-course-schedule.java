class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        int curr, order = 0;
        while(!q.isEmpty()){
            curr = q.poll();
            order++;
            for(int dep : dependant.getOrDefault(curr, new HashSet<>())){
                in[dep]--;
                if(in[dep] == 0) q.add(dep);
            }
        }
        return (order != numCourses) ? false : true;
    }
}