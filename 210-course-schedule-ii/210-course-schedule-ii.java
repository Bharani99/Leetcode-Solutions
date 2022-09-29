class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> dependant = new HashMap<>();
        
        HashSet<Integer> set;
        for(int[] prereq : prerequisites){
            set = map.getOrDefault(prereq[0], new HashSet<>());
            set.add(prereq[1]);
            map.put(prereq[0], set);
            
            set = dependant.getOrDefault(prereq[1], new HashSet<>());
            set.add(prereq[0]);
            dependant.put(prereq[1], set);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(!map.containsKey(i)) q.add(i);
        }

        int curr;
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            curr = q.poll();
            ans.add(curr);
            for(int dep : dependant.getOrDefault(curr, new HashSet<>())){
                set = map.get(dep);
                set.remove(curr);
                if(set.isEmpty()) q.add(dep);
            }
        }
        return (ans.size() != numCourses) ? new int[0] : ans.stream().mapToInt(i -> i).toArray();
    }
}